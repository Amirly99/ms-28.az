package ms28.az.repository;

import ms28.az.entity.BusEntity;
import ms28.az.model.Bus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BusRepository extends CrudRepository<BusEntity, Long> {
List<BusEntity> findAll();

}
