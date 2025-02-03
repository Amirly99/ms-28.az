package az.ingress.repository;

import az.ingress.entity.ComputerEntity;
import az.ingress.model.enums.ComputerStatus;
//import org.springframework.data.domain.Page;
//import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.time.LocalDate;
//import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


public interface ComputerRepository extends JpaRepository<ComputerEntity, Long>, JpaSpecificationExecutor<ComputerEntity> {
    //JpaRepository -> Bize methodlarin n sayda yaradilmasina serait yaardir ,amma buda her defesinde filetering zamani methodlarin yardilmasi normalda vaxt cehetden problem yardir;

    //    JpaSpecificationExecutor -> Burda ise filtering edende bize methodlari hazir sekilde verir;
    /*
    @Lock(value = LockModeType.PESSIMISTIC_READ) //Locklari bu sekilde yaza bilerik;
    Optional<ComputerEntity> findById(Long id);




    @Query(nativeQuery = true, value = "select * from computer where id= 2 for update ")
    Optional<ComputerEntity> findById(Long id);
     */

    Optional<ComputerEntity> findByIdAndStatusNot(Long id, ComputerStatus computerStatus);


   // List<ComputerEntity> findAll();
   Page<ComputerEntity> findAll(Specification<ComputerEntity> spec, Pageable pageable);


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
