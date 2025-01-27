package az.ingress.repository;

import az.ingress.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
    //@EntityGraph(attributePaths = {"profile", "orders"})
    @Override
    //@Query("SELECT  u FROM UsersEntity u JOIN FETCH u.profile")
    @Query(nativeQuery = true,value = "SELECT * FROM users u JOIN profile p ON u.id=p.id ")
    List<UsersEntity> findAll();

}
