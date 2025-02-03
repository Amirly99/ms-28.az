package az.ingress.entity.lab;

import az.ingress.model.lab.CreditsStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import liquibase.repackaged.org.apache.commons.lang3.builder.ToStringExclude;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "credits")
@EqualsAndHashCode(of = "id")
@Builder
@FieldNameConstants
public class CreditsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private Integer term;
    private BigDecimal interest;
    private BigDecimal monthlyPayment;
    private BigDecimal requestAmount;
    @Enumerated(value = EnumType.STRING)
    private CreditsStatus status;
    private LocalDate checkDate;
    private LocalDate updatedAt;
    @Column(name = "offer_id", nullable = true, insertable = false, updatable = false)
    private Long offerId; // Offer ID-ni saxlamaq üçün sütun


    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    @ToStringExclude
    @JsonIgnore
    private List<StatusHistoryEntity> statusHistoryEntityList;


    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToStringExclude
    @JsonIgnore
    private List<OffersEntity> offers;

    @ManyToOne(cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false
    )
    @ToStringExclude
    private CustomersEntity customer;


}
