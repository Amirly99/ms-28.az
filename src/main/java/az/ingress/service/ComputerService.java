package az.ingress.service;

import az.ingress.dto.ComputerDto;
import az.ingress.model.Computer;
import az.ingress.model.criteria.ComputerCriteria;
import az.ingress.model.criteria.PageCriteria;
import az.ingress.response.ComputerResponse;
import az.ingress.response.PageableResponse;

import java.util.List;

public interface ComputerService {

    void create(Computer computer);


    void update(Computer computer, Long id);

    void updateAll(ComputerDto computerDto, Long id);

    void delete(Long id);

    ComputerResponse getById(Long id);

    ComputerResponse updateCache(Long id);

    List<ComputerDto> getAll();

    void deleteCache();

    PageableResponse getComputer(ComputerCriteria computerCriteria, PageCriteria pageCriteria);

}
