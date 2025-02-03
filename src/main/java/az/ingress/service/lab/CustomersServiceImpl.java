package az.ingress.service.lab;

import az.ingress.entity.lab.CreditsEntity;
import az.ingress.entity.lab.CustomersEntity;
import az.ingress.mapper.PageableMapper;
import az.ingress.model.criteria.lab.CustomersCriteria;
import az.ingress.model.criteria.PageCriteria;
import az.ingress.repository.lab.CustomersRepository;
import az.ingress.response.PageableResponse;
import az.ingress.response.lab.CustomersResponse;
import az.ingress.specification.lab.CustomersSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static az.ingress.mapper.PageableMapper.PAGEABLE_MAPPER;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomersServiceImpl implements CustomersService {
    private final CustomersRepository customersRepository;

    @Override
    public void create(CustomersResponse customersResponse) {
        log.info("ActionLog.create.start customers: {}", customersResponse);
        customersRepository.save(CustomersEntity.builder()
                .pin(customersResponse.getPin())
                .phoneNumber(customersResponse.getPhoneNumber())
                .fullName(customersResponse.getFullName())

                .build());
        log.info("ActionLog.create.end customers: {}", customersResponse);

    }
@Transactional
    @Override
    public PageableResponse<CustomersEntity> getCustomers(CustomersCriteria customersCriteria, PageCriteria pageCriteria) {

        var pageRequest = PageRequest.of(pageCriteria.getPage(), pageCriteria.getCount(), Sort.by(CustomersEntity.Fields.id));
        var specification = new CustomersSpecification(customersCriteria);
        var customersPage = customersRepository.findAll(specification, pageRequest);

    return PageableMapper.buildPageableResponse(
            customersPage.getContent(),
            customersPage.getTotalPages(),
            customersPage.getTotalElements(),
            customersPage.hasNext()
    );


    }
}
