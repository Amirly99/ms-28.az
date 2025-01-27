package az.ingress.mapper;

import az.ingress.entity.ComputerEntity;
import az.ingress.response.ComputerResponse;

public enum ComputerMapper {
    //public static final ComputerMapper INSTANCE = new ComputerMapper();
    COMPUTER_MAPPER;

    public ComputerResponse toResponse(ComputerEntity entity) {

        return ComputerResponse.builder()
                .computerMark(entity.getComputerMark())
                .amount(entity.getAmount())
                .date(entity.getDate())

                .build();
    }


}


