package az.ingress.mapper;

import az.ingress.entity.lab.CustomersEntity;
import az.ingress.response.lab.CustomersResponse;

public enum CustomersMapper {

    CUSTOMERS_MAPPER;

    public CustomersResponse customersResponse(CustomersEntity entity) {

        return CustomersResponse.builder()
                .pin(entity.getPin())
                .phoneNumber(entity.getPhoneNumber())
                .fullName(entity.getFullName())
                .build();
    }
}
