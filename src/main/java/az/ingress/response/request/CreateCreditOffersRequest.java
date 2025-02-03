package az.ingress.response.request;

import az.ingress.response.lab.CreditsResponse;
import az.ingress.response.lab.OffersResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCreditOffersRequest {

    private CreditsResponse creditsResponse;
    private OffersResponse offersResponse;
}
