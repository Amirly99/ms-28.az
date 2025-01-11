package az.ingress.service;

import az.ingress.entity.OrderEntity;
import az.ingress.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    @Transactional(propagation = Propagation.REQUIRES_NEW)//@Transactional(propagation = Propagation.REQUIRED)
    //ve ya tekce @Transactional secseydik o zaman her iki sorgumuz roolBack olunacaqdi ;
    //Burda meqsed odur ki,ferqli bean yaradaraq eyni anda iki @Transactional gonderib derqli ferqli neticler elde etmek olsun
    //+ Biz best bean uzre ferqli-ferqli @Transactional gondere bilmerik hamsi eyni anda Default @Transactional uzerinde ise dusecek;

    public void testing5(){

        orderRepository.save((OrderEntity.builder()
                .orderName("PhoneOrder")
                .orderAmount(new BigDecimal(55))
                .date(LocalDate.now())
                .build()));

    }
}
