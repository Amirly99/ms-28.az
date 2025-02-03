package az.ingress.service.lab;

import az.ingress.entity.lab.CreditsEntity;
import az.ingress.entity.lab.CustomersEntity;
import az.ingress.entity.lab.OffersEntity;
import az.ingress.model.lab.CreditsStatus;
import az.ingress.repository.lab.CreditsRepository;
import az.ingress.repository.lab.CustomersRepository;
import az.ingress.repository.lab.OffersRepository;
import az.ingress.response.lab.CreditsResponse;
import az.ingress.response.lab.OffersResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreditsServiceImpl implements CreditsService {
    private final CreditsRepository creditsRepository;
    private final CustomersRepository customersRepository;
    private final OffersRepository offersRepository;
    private final OffersService offersService;

    @Transactional

    @Override
    public void create(CreditsResponse creditsResponse, OffersResponse offersResponse) {


        log.info("start is saving  to create credit account ");
        CustomersEntity existingCustomer = customersRepository.findById(creditsResponse.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + creditsResponse.getCustomerId()));
        log.info("ActionLog.create.start credits: {}", creditsResponse);


        var creditSave = creditsRepository.save(CreditsEntity.builder()
                .requestAmount(creditsResponse.getRequestAmount())
                .amount(creditsResponse.getAmount())
                .status(CreditsStatus.DRAFT)
                .checkDate(LocalDate.now().plusDays(5))
                .customer(existingCustomer)

                .build());
        log.info("ActionLog.create.end credits: {}", creditsResponse);
        log.info("Creating offer. Credit ID: {}, Offer Details: {}", creditSave.getId(), offersResponse);
        offersResponse.setCreditId(creditSave.getId());
        offersService.setOffers(offersResponse);
        log.info("Offer successfully created and linked with credit. Credit ID: {}, Offer ID: {}", creditSave.getId(), offersResponse.getCreditId());
        ;
    }


    //@Transactional
    @Override
    public List<CreditsEntity> getCreditsByStatus(CreditsStatus creditsStatus) {
        log.info("ActionLog.getCreditsByStatus.Get all credits by status creditsStatus:{}", creditsStatus);
        return creditsRepository.findByStatus(creditsStatus);

    }

    @Override
    public List<OffersEntity> getOffersByCreditId(Long creditId) {
        log.info("ActionLog.getOffersByCreditId.Get offers by creditId: {}", creditId);
        return offersRepository.findByCreditId(creditId);

    }

    @Transactional
    @Override
    public void acceptCreditStatus(Long offerId) {


        OffersEntity offer = offersRepository.findById(offerId)
                .orElseThrow(() -> new RuntimeException("Offer not found with id: " + offerId));

        CreditsEntity credit = offer.getCredit();

        if (credit != null) {

            credit.setStatus(CreditsStatus.REJECTED);

            creditsRepository.save(credit);

            offer.setAccepted(true);
            offersRepository.save(offer);

        } else {
            throw new RuntimeException("No associated credit found for offerId: " + offerId);
        }
    }

    @Transactional
    @Override
    public void updateExpiredCredits() {
        int updatedRows = creditsRepository.markExpiredCredits(LocalDate.now());
        System.out.println(updatedRows + " credits updated to EXPIRED.");
        log.info("ActionLog.updateExpiredCredits.update credits status:{}", +updatedRows);
    }

}






