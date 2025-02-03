package az.ingress.repository.lab;

import az.ingress.entity.lab.CreditsEntity;
import az.ingress.entity.lab.CustomersEntity;
import az.ingress.model.lab.CreditsStatus;
import liquibase.license.LicenseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface CustomersRepository extends JpaRepository<CustomersEntity,Long >,JpaSpecificationExecutor<CustomersEntity> {

}
