package az.ingress.entity.lab;

import com.fasterxml.jackson.annotation.JsonIgnore;
import liquibase.repackaged.org.apache.commons.lang3.builder.ToStringExclude;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "offers")
@EqualsAndHashCode(of = "id")
@Builder
@FieldNameConstants
public class OffersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private Integer term;
    private BigDecimal interest;
    private Boolean accepted;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    @Column(name = "credit_id", nullable = false, insertable = false, updatable = false)
    private Long creditId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    @ToStringExclude
    private CreditsEntity credit;
}
