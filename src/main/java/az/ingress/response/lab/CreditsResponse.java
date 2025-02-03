package az.ingress.response.lab;

import az.ingress.model.lab.CreditsStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditsResponse {
    private BigDecimal amount;
    private Integer term;
    private BigDecimal interest;
    private BigDecimal monthlyPayment;
    private BigDecimal requestAmount;
    @Enumerated(value = EnumType.STRING)
    private CreditsStatus status;
    private LocalDate checkDate;
    private LocalDate updatedAt;
    private Long customerId;


}
