package ms28.az.entity;

import jakarta.persistence.*;
import lombok.*;
import ms28.az.model.Enums.ReservationsStatus;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservations")
@EqualsAndHashCode(of = "id")
@Builder
public class ReservationsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tableName;
    private String customerName;
    private LocalDate date;
    private String status;
    private int count_members;
    @Enumerated(value = EnumType.STRING)
    private ReservationsStatus inactive;

}
