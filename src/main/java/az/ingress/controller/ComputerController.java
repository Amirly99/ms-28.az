package az.ingress.controller;

import az.ingress.dto.ComputerDto;
import az.ingress.model.Computer;
import az.ingress.model.ComputerResponse;
import az.ingress.service.ComputerService;
import lombok.RequiredArgsConstructor;
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
    }@PutMapping(value = "/{id}/all")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateAll(@RequestBody ComputerDto computerDto, @PathVariable Long id) {

        computerService.updateAll(computerDto, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        computerService.delete(id);

    }

    @GetMapping(value = "/{id}")
    public ComputerResponse getById(@PathVariable Long id) {

        return computerService.getById(id);
    }

    @GetMapping(value = "/findAll")
    public List<ComputerDto> getAll() {

        return computerService.getAll();

    }

}
