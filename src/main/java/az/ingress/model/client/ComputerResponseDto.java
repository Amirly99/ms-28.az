package az.ingress.model.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComputerResponseDto {
    private Long id;
    private String computerMark;
    private BigDecimal amount;
    private LocalDate date;

}
