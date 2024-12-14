package az.ingress.repository;

import az.ingress.entity.ComputerEntity;
import az.ingress.model.ComputerStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ComputerRepository extends CrudRepository<ComputerEntity, Long> {
    Optional<ComputerEntity> findByIdAndStatusNot(Long id, ComputerStatus computerStatus);

    List<ComputerEntity> findAll();

    Optional<ComputerEntity> findByComputerMarkAndDateAfter(String computerMark, LocalDate date);

    Optional<ComputerEntity> findByComputerMarkAndAmount(String computerMark, BigDecimal amount);

    @Query(nativeQuery = true,
            value = """
                    SELECT id 
                    FROM computer
                     WHERE computer_mark=:computerMark

                        """
    )
    Long findByComputerMark(String computerMark);

@Query(value = "select id from ComputerEntity  where amount=:amount")
Long findByAmount(BigDecimal amount);


}
