package ms28.az.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ms28.az.model.Enums.BusStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusDto {


    private Long id;
    private String busName;
    private String busColor;
    private LocalDateTime createdAt;
    private BigDecimal amount;
    private int passengersNumber;
    @Enumerated(value = EnumType.STRING)
    private BusStatus status;
}
