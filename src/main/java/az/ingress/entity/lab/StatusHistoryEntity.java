package az.ingress.entity.lab;

import az.ingress.model.lab.StatusHistoryStatus;
import liquibase.repackaged.org.apache.commons.lang3.builder.ToStringExclude;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "status_history")
@EqualsAndHashCode(of = "id")
@Builder
@FieldNameConstants
public class StatusHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private StatusHistoryStatus historyStatus;
    private LocalDate createdAt;
    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_id",referencedColumnName = "id")
    @ToStringExclude
    private CreditsEntity credit;
}
