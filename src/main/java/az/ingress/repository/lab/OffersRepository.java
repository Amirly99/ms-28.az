package az.ingress.repository.lab;

import az.ingress.entity.lab.OffersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffersRepository extends JpaRepository<OffersEntity, Long> {

    //Long findById();

    List<OffersEntity> findByCreditId(Long creditId);
    
}
