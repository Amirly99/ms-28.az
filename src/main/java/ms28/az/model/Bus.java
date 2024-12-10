package ms28.az.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Bus {
    private String busName;
    private String busColor;
    private BigDecimal amount;
    private int passengersNumber;
}
