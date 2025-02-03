package az.ingress.repository.lab;

import az.ingress.entity.lab.CreditsEntity;
import az.ingress.entity.lab.OffersEntity;
import az.ingress.model.lab.CreditsStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CreditsRepository extends JpaRepository<CreditsEntity ,Long >, JpaSpecificationExecutor<CreditsEntity> {
    List<CreditsEntity> findByStatus(CreditsStatus creditsStatus);
    List<CreditsEntity> findByStatusAndCheckDateBefore(CreditsStatus creditsStatus, LocalDate checkDate);
/*
    @Modifying
    @Transactional
    @Query("UPDATE CreditsEntity c SET c.status = :status WHERE c.id = (SELECT o.credit.id FROM OffersEntity o WHERE o.id = :offerId)")
    void updateCreditStatusByOfferId(@Param("offerId") Long offerId, @Param("status") CreditsStatus status
    );


 */

    @Modifying
    @Transactional
    @Query("UPDATE CreditsEntity c SET c.status = 'EXPIRED' WHERE c.checkDate < :currentDate")
    int markExpiredCredits(LocalDate currentDate);
}

