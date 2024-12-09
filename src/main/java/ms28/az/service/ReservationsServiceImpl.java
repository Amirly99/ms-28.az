package ms28.az.service;

import lombok.RequiredArgsConstructor;
import ms28.az.entity.ReservationsEntity;
import ms28.az.model.Enums.ReservationsStatus;
import ms28.az.model.Reservations;
import ms28.az.model.ReservationsStatusUpdate;
import ms28.az.repository.ReservationsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationsServiceImpl implements ReservationsService {
    private final ReservationsRepository reservationsRepository;

    @Override
    public void create(Reservations reservations) {
        reservationsRepository.save(ReservationsEntity.builder()
                .tableName(reservations.getTableName())
                .customerName(reservations.getCustomerName())
                .status(reservations.getStatus())
                .count_members(reservations.getCount_members())
                .build());


    }

    @Override
    public void update(ReservationsStatusUpdate reservationsStatusUpdate, Long id) {
        var reservations = reservationsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Cannot"));
        reservations.setStatus(reservations.getStatus());
        reservationsRepository.save(reservations);
    }

    @Override
    public void delete(Long id) {
        var reservations = reservationsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Cannot"));
        reservations.setStatus(String.valueOf(ReservationsStatus.ACTIVE));
        reservationsRepository.save(reservations);

    }
/*
    @Override
    public List<ReservationsEntity> getAll() {
        ReservationsEntity reservations=new ReservationsEntity();
        return reservationsRepository.findAll()
                .stream()
                .map(()-> new ReservationsEntity.ReservationsEntityBuilder()
                        .customerName(reservations.getCustomerName())
                        .tableName(reservations.getTableName())
                        .date(reservations.getDate())
                        .count_members(reservations.getCount_members())
                        .status(reservations.getStatus())

                        .build());

        }

 */






    @Override
    public Reservations getById(Long id) {
        var reservations = reservationsRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Not Cannot"));
        return new Reservations(reservations.getTableName(), reservations.getCustomerName(), reservations.getStatus(), reservations.getCount_members());

    }

}
