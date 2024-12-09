package ms28.az.service;

import ms28.az.entity.ReservationsEntity;
import ms28.az.model.Reservations;
import ms28.az.model.ReservationsStatusUpdate;

import java.util.List;

public interface ReservationsService {

    void create(Reservations reservations);

    void update(ReservationsStatusUpdate reservationsStatusUpdate, Long id);
    void delete(Long id);
   // List<ReservationsEntity> getAll();
    Reservations getById(Long id);




}
