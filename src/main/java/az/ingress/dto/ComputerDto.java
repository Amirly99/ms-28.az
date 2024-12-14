package az.ingress.dto;

import az.ingress.model.ComputerStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComputerDto {

    private String computerMark;
    private BigDecimal amount;
    private LocalDate date;
    @Enumerated(value = EnumType.STRING)
    private ComputerStatus status;


}
