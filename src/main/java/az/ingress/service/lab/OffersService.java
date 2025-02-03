package az.ingress.service.lab;

import az.ingress.entity.lab.CreditsEntity;
import az.ingress.entity.lab.OffersEntity;
import az.ingress.repository.lab.CreditsRepository;
import az.ingress.repository.lab.OffersRepository;
import az.ingress.response.lab.OffersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class OffersService {
    private final OffersRepository offersRepository;
    private final CreditsRepository creditsRepository;


    public OffersEntity setOffers(OffersResponse offersResponse) {
        CreditsEntity credits = creditsRepository.findById(offersResponse.getCreditId())
                .orElseThrow(() -> new RuntimeException("Credit not found with id: " + offersResponse.getCreditId()));
        return offersRepository.save(OffersEntity.builder()
                .amount(BigDecimal.valueOf(666))
                .term(12)
                .interest(BigDecimal.TEN)
                .credit(credits)
                .build());

    }
}
