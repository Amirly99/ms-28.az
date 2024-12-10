package ms28.az.service;

import ms28.az.dto.BusDto;
import ms28.az.entity.BusEntity;
import ms28.az.model.Bus;
import ms28.az.model.BusColorUpdate;

import java.util.List;

public interface BusService {
    void create(Bus bus);

    void update(BusColorUpdate busColorUpdate, Long id);

    void delete(Long id);

    Bus getBus(Long id);
     List<BusDto> getAll();

}
