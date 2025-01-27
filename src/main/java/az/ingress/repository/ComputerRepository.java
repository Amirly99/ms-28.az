package az.ingress.repository;

import az.ingress.entity.ComputerEntity;
import az.ingress.model.ComputerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ComputerRepository extends JpaRepository<ComputerEntity, Long>, JpaSpecificationExecutor<ComputerEntity> {
    //JpaRepository -> Bize methodlarin n sayda yaradilmasina serait yaardir ,amma buda her defesinde filetering zamani methodlarin yardilmasi normalda vaxt cehetden problem yardir;

//    JpaSpecificationExecutor -> Burda ise filtering edende bize methodlari hazir sekilde verir;
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
