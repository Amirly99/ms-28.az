package az.ingress.controller;

import az.ingress.annotations.HandleException;
import az.ingress.annotations.LogExecution;
import az.ingress.annotations.TrackTime;
import az.ingress.dto.ComputerDto;
import az.ingress.entity.ComputerEntity;
import az.ingress.model.Computer;
import az.ingress.model.criteria.ComputerCriteria;
import az.ingress.model.criteria.PageCriteria;
import az.ingress.response.ComputerResponse;
import az.ingress.response.PageableResponse;
import az.ingress.service.ComputerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "v1/computers")
public class ComputerController {

    private final ComputerService computerService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody Computer computer) {

        computerService.create(computer);
    }

    @PatchMapping(value = "/{id}/mark&amount")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Computer computer, @PathVariable Long id) {

        computerService.update(computer, id);
    }

    @PutMapping(value = "/{id}/all")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateAll(@RequestBody ComputerDto computerDto, @PathVariable Long id) {

        computerService.updateAll(computerDto, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        computerService.delete(id);

    }
@TrackTime
@HandleException
@LogExecution
    @GetMapping(value = "/{id}")
    public ComputerResponse getById(@PathVariable Long id) {

        return computerService.getById(id);
    }
/*
    @GetMapping(value = "/findAll")
    public List<ComputerDto> getAll() {

        return computerService.getAll();

    }

 */

    @DeleteMapping(value = "/cache")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCache() {
        computerService.deleteCache();

    }

    @PutMapping(value = "/cache")
    public ComputerResponse updateCache(@RequestParam Long id) {
        return computerService.updateCache(id);
    }

    @GetMapping
    public PageableResponse<ComputerEntity> getComputer(ComputerCriteria computerCriteria, PageCriteria pageCriteria) {

        return computerService.getComputer(computerCriteria, pageCriteria);
    }
}

