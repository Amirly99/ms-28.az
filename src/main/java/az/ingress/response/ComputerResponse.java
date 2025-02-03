package az.ingress.response;

import az.ingress.model.Computer;
import az.ingress.model.enums.ComputerStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComputerResponse {
    private Long id;

    private String computerMark;
    private BigDecimal amount;
    private LocalDate date;


}
