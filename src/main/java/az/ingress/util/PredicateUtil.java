package az.ingress.util;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PredicateUtil {

    private final List<Predicate> predicates = new ArrayList<>();

    public static PredicateUtil builder() {
        return new PredicateUtil();

    }

    public <T> PredicateUtil add(T object, Function<T, Predicate> function) {//Mecbur data filter edilen zaman istifade olunur;

        predicates.add(function.apply(object));
        return this;
    }

    public <T> PredicateUtil addNullSafety(T value, Function<T, Predicate> predicateFunction) {//Musteri isdeyine gore filter olunan zaman bu methodan istifade olunur;
        if (value != null) {
            predicates.add(predicateFunction.apply(value));
        } else {
        throw new IllegalArgumentException("Object cannot be null when using add method.");
    }

        return this;
    }

    public List<Predicate> build() {
        return predicates;
    }
}
