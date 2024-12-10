package ms28.az.entity;

import jakarta.persistence.*;
import lombok.*;
import ms28.az.model.Enums.BusStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bus")
@EqualsAndHashCode(of = "id")
@Builder

public class BusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String busName;
    private String busColor;
    private LocalDateTime createdAt;
    private BigDecimal amount;
    private int passengersNumber;
    @Enumerated(value = EnumType.STRING)
    private BusStatus status;
}
