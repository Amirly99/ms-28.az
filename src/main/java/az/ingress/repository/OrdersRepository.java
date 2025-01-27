package az.ingress.repository;

import az.ingress.entity.OrdersEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<OrdersEntity ,Long> {
}
