package ms28.az.service;

import lombok.RequiredArgsConstructor;
import ms28.az.dto.BusDto;
import ms28.az.entity.BusEntity;
import ms28.az.model.Bus;
import ms28.az.model.BusColorUpdate;
import ms28.az.model.Enums.BusStatus;
import ms28.az.repository.BusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BusServiceImpl implements BusService {

    private final BusRepository busRepository;

    @Override
    public void create(Bus bus) {
        busRepository.save(BusEntity.builder()
                .busName(bus.getBusName())
                .busColor(bus.getBusColor())
                .amount(bus.getAmount())
                .passengersNumber(bus.getPassengersNumber())
                .build());

    }

    @Override
    public void update(BusColorUpdate busColorUpdate, Long id) {
        var bus = busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not cannot"));
        bus.setBusColor(bus.getBusColor());
        busRepository.save(bus);

    }

    @Override
    public void delete(Long id) {
        var bus = busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not cannot"));
        bus.setStatus(BusStatus.M2);
        busRepository.save(bus);
    }

    @Override
    public Bus getBus(Long id) {
        var bus = busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not cannot"));
        return new Bus(bus.getBusName(), bus.getBusColor(), bus.getAmount(), bus.getPassengersNumber());


    }

    @Override
    public List<BusDto> getAll() {
        return busRepository.findAll()
                .stream()
                .map(busEntity -> {
                    return BusDto.builder()
                            .id(busEntity.getId())
                            .busName(busEntity.getBusName())
                            .busColor(busEntity.getBusColor())
                            .amount(busEntity.getAmount())
                            .status(busEntity.getStatus())
                            .createdAt(busEntity.getCreatedAt())
                            .passengersNumber(busEntity.getPassengersNumber())
                            .build();


                }).toList();


    }
}
