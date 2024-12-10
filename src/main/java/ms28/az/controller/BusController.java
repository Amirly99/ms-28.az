package ms28.az.controller;

import lombok.RequiredArgsConstructor;
import ms28.az.dto.BusDto;
import ms28.az.model.Bus;
import ms28.az.model.BusColorUpdate;
import ms28.az.service.BusService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "v1/busy")
public class BusController {
    private final BusService busService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody Bus bus) {

        busService.create(bus);
    }

    @PatchMapping(value = "/{id}/color")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody BusColorUpdate busColorUpdate) {
        busService.update(busColorUpdate, id);


    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        busService.delete(id);

    }

    @GetMapping(value = "/{id}")
    public Bus getBus(@PathVariable Long id) {

        return busService.getBus(id);
    }

    @GetMapping(value = "/bus")
    public List<BusDto> getAll() {
        return busService.getAll();

    }


}
