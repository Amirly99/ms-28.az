package ms28.az.controller;

import lombok.RequiredArgsConstructor;
import ms28.az.model.Reservations;
import ms28.az.model.ReservationsStatusUpdate;
import ms28.az.service.ReservationsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "v1/reservations")
public class ReservationsController {
    private final ReservationsService reservationsService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody Reservations reservations) {

        reservationsService.create(reservations);
    }

    @PatchMapping(value = "/{id}/status")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody ReservationsStatusUpdate reservationsStatusUpdate, @PathVariable Long id) {

        reservationsService.update(reservationsStatusUpdate, id);
    }


    @GetMapping(value = "/{id}")
    public Reservations getById(@PathVariable Long id) {

        return reservationsService.getById(id);

    }
}
