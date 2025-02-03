package az.ingress.specification.lab;

import az.ingress.entity.lab.CustomersEntity;
import az.ingress.model.criteria.lab.CustomersCriteria;
import az.ingress.util.PredicateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Data
@AllArgsConstructor
public class CustomersSpecification implements Specification<CustomersEntity> {
    private CustomersCriteria customersCriteria;

    @Override
    public Predicate toPredicate(@NonNull Root<CustomersEntity> root, 
                                @NonNull CriteriaQuery<?> query, 
                                @NonNull CriteriaBuilder criteriaBuilder) {

        var predicates = PredicateUtil.builder()
                .addNullSafety(customersCriteria.getPin(),
                        pin -> criteriaBuilder.equal(root.get("pin"), pin)
                )

                .addNullSafety(customersCriteria.getPhoneNumber(),
                        phoneNumber -> criteriaBuilder.equal(root.get("phoneNumber"), phoneNumber)
                )

                .addNullSafety(customersCriteria.getFullName(),
                        fullName -> criteriaBuilder.like(root.get("fullName"), test(fullName))
                )

                .build();
        return criteriaBuilder.and(predicates);
    }

    public String test(String string) {

        return "%" + string + "%";
    }
}
