package az.ingress.service;

import az.ingress.dto.ComputerDto;
import az.ingress.entity.ComputerEntity;
import az.ingress.model.Computer;
import az.ingress.model.ComputerResponse;
import az.ingress.model.ComputerStatus;
import az.ingress.repository.ComputerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComputerServiceImpl implements ComputerService {
    private final ComputerRepository computerRepository;

    @Override
    public void create(Computer computer) {
        computerRepository.save(ComputerEntity.builder()
                .computerMark(computer.getComputerMark())
                .amount(computer.getAmount())
                .date(LocalDate.now())
                .status(ComputerStatus.MACHINE)
                .build());

    }

    @Override
    public void update(Computer computer, Long id) {
        var comp = fetchOrderIfExist(id);
        comp.setComputerMark(computer.getComputerMark());
        comp.setAmount(computer.getAmount());
        computerRepository.save(comp);


    }

    @Override
    public void updateAll(ComputerDto computerDto, Long id) {
        var comp = fetchOrderIfExist(id);
        comp.setComputerMark(computerDto.getComputerMark());
        comp.setAmount(computerDto.getAmount());
        comp.setStatus(ComputerStatus.MACHINE);
        computerRepository.save(comp);
    }

    @Override
    public void delete(Long id) {
        var comp = fetchOrderIfExist(id);
        comp.setStatus(ComputerStatus.RUNNING);
        computerRepository.save(comp);

    }

    @Override
    public ComputerResponse getById(Long id) {

        var comp = fetchOrderIfExist(id);

        return new ComputerResponse(comp.getComputerMark(), comp.getAmount(), comp.getDate());

    }

    @Override
    public List<ComputerDto> getAll() {
        return computerRepository.findAll().stream().map(computerEntity -> {
            return ComputerDto.builder()
                    .computerMark(computerEntity.getComputerMark())
                    .amount(computerEntity.getAmount())
                    .date(computerEntity.getDate())
                    .status(computerEntity.getStatus())


                    .build();


        }).toList();


    }

    private ComputerEntity fetchOrderIfExist(Long id) {
        return computerRepository.findByIdAndStatusNot(id, ComputerStatus.RUNNING).
                orElseThrow(() -> new RuntimeException("Not cannot"));

    }

    /*
        @PostConstruct
        public void test() {

            var comp = computerRepository.findByComputerMarkAndDateAfter("Mac", LocalDate.of(2024,12,14)).get();

            System.out.println("Computer Id:" + comp.getId());
        }


    @PostConstruct
    public void fly() {

        var cma = computerRepository.findByComputerMarkAndAmount("Mac", (new BigDecimal("60"))).get();
        System.out.println("Computer:" + cma.getId());


    }

    @PostConstruct
    public void fly1() {
        var id = computerRepository.findByComputerMark("Mac");
        System.out.println("Computer:" + id);
    }

    @PostConstruct
    public void fly2() {

        var id2 = computerRepository.findByAmount(new BigDecimal(60));
        System.out.println("Computer:" + id2);
    }

     */

}
