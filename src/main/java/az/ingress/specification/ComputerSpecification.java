package az.ingress.specification;

import az.ingress.entity.ComputerEntity;
import az.ingress.model.ComputerStatus;
import az.ingress.model.criteria.ComputerCriteria;
import az.ingress.util.PredicateUtil;
import lombok.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


@AllArgsConstructor
@Data

public class ComputerSpecification implements Specification<ComputerEntity> {


    private   ComputerCriteria computerCriteria;



    @Override
    public Predicate toPredicate(Root<ComputerEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        var predicate = PredicateUtil.builder()
                /*
                .addNullSafety(computerCriteria.getComputerMark(),
                        computerMark -> criteriaBuilder.equal(root.get("computerMark"), computerMark)
                )

                 */
                .addNullSafety(computerCriteria.getComputerMark(),
                        computerMark -> criteriaBuilder.like(root.get("computerMark"),applyLikePattern(computerMark) )
                        //"%" + computerMark + "%"
                )
                .addNullSafety(computerCriteria.getAmountFrom(),
                        amountFrom -> criteriaBuilder.greaterThanOrEqualTo(root.get("amount"), amountFrom)
                )
                .addNullSafety(computerCriteria.getAmountTo(),
                        amountTo -> criteriaBuilder.lessThanOrEqualTo(root.get("amount"), amountTo)
                )
                .add(ComputerStatus.MACHINE, status -> criteriaBuilder.notEqual(root.get("status"), status))
                .build();


        return criteriaBuilder.and((Predicate) predicate);
    }




    private String applyLikePattern(String data){
        return "%" +data + "%";
    }


}
