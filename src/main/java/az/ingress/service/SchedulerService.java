package az.ingress.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SchedulerService {

    public void sendBirthdayEmail() {
        log.info("Happy Birthday!");
    }
    public void sendPaymentEmail() {
        log.info("Payment!");
    }

   /* @SneakyThrows
    @Async
    public void saveScheduler(){
        Thread.sleep(2000L);
        log.info("User!");
        throw new RuntimeException("");


    }


    */
    public void sendCostumerEmail(){

        log.info("Costumer!");
    }
}
