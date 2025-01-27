package az.ingress.repository;

import az.ingress.entity.ProfileEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<ProfileEntity,Long> {
}
