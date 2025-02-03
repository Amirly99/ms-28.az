package az.ingress.controller.lab;

import az.ingress.entity.lab.CreditsEntity;
import az.ingress.entity.lab.OffersEntity;
import az.ingress.model.lab.CreditsStatus;
import az.ingress.response.request.CreateCreditOffersRequest;
import az.ingress.service.lab.CreditsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/credits")
public class CreditsController {

    private final CreditsService creditsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateCreditOffersRequest createCreditOffersRequest) {
        creditsService.create(createCreditOffersRequest.getCreditsResponse(), createCreditOffersRequest.getOffersResponse());

    }

    @GetMapping("/status")
    public List<CreditsEntity> getCreditsByStatus(@RequestParam CreditsStatus creditsStatus) {

        List<CreditsEntity> credits = creditsService.getCreditsByStatus(creditsStatus);
        return ResponseEntity.ok(creditsService.getCreditsByStatus(creditsStatus)).getBody();
    }

    @GetMapping("/offers/{creditId}")
    public List<OffersEntity> getOffersByCreditId(@PathVariable Long creditId) {


        return creditsService.getOffersByCreditId(creditId);
    }

    /*
        @PatchMapping(value = "/accept/{offerId}")
        public void acceptCreditStatus(Long offerId){
            creditsService.acceptCreditStatus(offerId);

        }

     */
    @PostMapping("/accept-credit/{offerId}")
    public void acceptCreditStatus(@PathVariable Long offerId) {
        creditsService.acceptCreditStatus(offerId);
    }

}
