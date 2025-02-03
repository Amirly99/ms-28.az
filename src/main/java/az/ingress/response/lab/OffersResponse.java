package az.ingress.response.lab;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OffersResponse {
    private BigDecimal amount;
    private Integer term;
    private BigDecimal interest;
    private Long creditId;
}
