package az.ingress.service;

import az.ingress.dto.ComputerDto;
import az.ingress.model.Computer;
import az.ingress.model.ComputerResponse;

import java.util.List;

public interface ComputerService {

    void create(Computer computer);

    void update(Computer computer, Long id);

    void updateAll(ComputerDto computerDto, Long id);

    void delete(Long id);

    ComputerResponse getById(Long id);

    List<ComputerDto> getAll();

}
