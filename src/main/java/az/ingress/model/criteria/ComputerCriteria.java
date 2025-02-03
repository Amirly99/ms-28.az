package az.ingress.model.criteria;

import az.ingress.model.enums.ComputerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ComputerCriteria {
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private BigDecimal amountFrom;
    private BigDecimal amountTo;
    private String computerMark;
    private ComputerStatus status;


}
