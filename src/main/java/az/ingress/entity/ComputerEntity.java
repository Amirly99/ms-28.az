package az.ingress.entity;

import az.ingress.model.ComputerStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "computer")
@Entity
@Builder

public class ComputerEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String computerMark;
    private BigDecimal amount;
    private LocalDate date;
    @Enumerated(value = EnumType.STRING)
    private ComputerStatus status;
}
