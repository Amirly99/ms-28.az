package az.ingress.specification;

import az.ingress.entity.ComputerEntity;
import az.ingress.model.criteria.ComputerCriteria;
import az.ingress.model.enums.ComputerStatus;
import az.ingress.util.PredicateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


@AllArgsConstructor
@Data
@Slf4j

public class ComputerSpecification implements Specification<ComputerEntity> {


    private ComputerCriteria computerCriteria;


    @Override
    public Predicate toPredicate(@NonNull Root<ComputerEntity> root, 
                                @NonNull CriteriaQuery<?> query, 
                                @NonNull CriteriaBuilder criteriaBuilder) {

        var predicates = PredicateUtil.builder()


                .addNullSafety(computerCriteria.getComputerMark(),
                        // computerMark -> criteriaBuilder.equal(root.get("computerMark"), computerMark),
                        computerMark -> !computerMark.isBlank() ?
                                criteriaBuilder.like(root.get("computerMark"), applyLikePattern(computerMark)):null
                        //"%" + computerMark + "%"
                )

                .addNullSafety(computerCriteria.getAmountFrom(),
                        amountFrom -> criteriaBuilder.greaterThanOrEqualTo(root.get("amount"), amountFrom)
                )
                .addNullSafety(computerCriteria.getAmountTo(),
                        amountTo -> criteriaBuilder.lessThanOrEqualTo(root.get("amount"), amountTo)
                )
                .addNullSafety(computerCriteria.getDateFrom(),
                        dateFrom -> criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), dateFrom)
                )
                .addNullSafety(computerCriteria.getDateTo(),
                        dateTo -> criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), dateTo)

                )
                .add(ComputerStatus.MACHINE, status -> criteriaBuilder.notEqual(root.get("status"), status))


                .build();

        return criteriaBuilder.and(predicates);
    }


    private String applyLikePattern(String data) {
        return "%" + data + "%";
    }


}
