package az.ingress.service.lab;

import az.ingress.entity.lab.CreditsEntity;
import az.ingress.entity.lab.OffersEntity;
import az.ingress.model.lab.CreditsStatus;
import az.ingress.response.lab.CreditsResponse;
import az.ingress.response.lab.OffersResponse;

import java.util.List;

public interface CreditsService {

    void create(CreditsResponse creditsResponse, OffersResponse offersResponse);

    List<CreditsEntity> getCreditsByStatus(CreditsStatus creditsStatus);

    List<OffersEntity> getOffersByCreditId(Long creditId);
    void acceptCreditStatus(Long offerId);
    //void rejectCreditStatus(Long offerId);
    void updateExpiredCredits();


}
