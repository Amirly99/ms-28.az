package ms28.az.repository;

import ms28.az.entity.ReservationsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationsRepository extends CrudRepository<ReservationsEntity, Long> {

    List<ReservationsEntity> findAll();

}
