package az.ingress.scheduler;

import az.ingress.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BirthdayScheduler {
    private final SchedulerService schedulerService;

    /*
        @Scheduled(fixedDelayString = "PT1S")//String sekilnde vaxti teyin ede bilerik yeni max ne qeder muddetinde locklansin method;
        @SchedulerLock(name = "sendBirthdayEmail", lockAtLeastFor = "PT1S", lockAtMostFor = "PT1M")
        lockAtLeastFor -> Min lock ;
        lockAtMostFor  -> Max lock;
        name - > Yeni hansi methodu lockluyuruq ve ya istenilen name vere bilerik;

        @SneakyThrows - > Thread.sleep(5000L);
        @Async Proxy DP esasinda isleyir burda qeyd etsek o zaman Thread.sleep(5000L); olmagina nezeren yene
         esas vaxtinda ise dusecek yeni 1 saniyeden bir lock edecek;
        public void sendBirthdayEmail() {
            Thread.sleep(5000L);//Normalda lockAtLeastFor -> Min lock  verdiyimzden daha gec ise dusecek;
            schedulerService.sendBirthdayEmail();


        }



    @Scheduled(fixedDelay = 5000L) //Burada long qebul edir vaxt yeni bu sekildede teyin ede bilerik yeni bu vaxt
    // esasinda locklamasi davam etsin;
    @SchedulerLock(name = "sendBirthdayEmail",lockAtLeastFor = "PT1S",lockAtMostFor = "PT1M")
    @SneakyThrows
    @Async
    public void sendBirthdayEmail(){
        schedulerService.sendBirthdayEmail();
        Thread.sleep(2000L);
    }






    @Scheduled(fixedDelayString = "PT1S")
  //  @Scheduled(cron = " 1* * * * *") //cron sekildede vaxti teyin etmek olar burda 5M (deqiqe) secmis oldug;
    @SchedulerLock(name = "sendCostumerEmail", lockAtLeastFor = "PT7S", lockAtMostFor = "PT1M")
    @SneakyThrows
    @Async
    public void sendCostumerEmail() {
        schedulerService.sendCostumerEmail();
        Thread.sleep(5000L);

    }








    @Scheduled(fixedDelayString = "PT1S")
    @SchedulerLock(name = "sendPaymentEmail", lockAtLeastFor = "PT7S", lockAtMostFor = "PT1M")
    //Eger biz SchedulerLocku baglasaq tek real schedulere verdiyimiz vaxt araliginda ise dusecek ;
    //Yox eyer  @Scheduled(fixedDelayString = "PT1S") vaxt teyin etmisikse ,@SchedulerLock vaxti deyisek o zaman
    //@SchedulerLock hansi vaxti teyin etmisikse Min/Max o araligda lockluyacaq ve isleyecek;
    @SneakyThrows
    @Async
    //Qeyd etsek ozaman Thread.sleep(5000L); baxmadan evvelki yene 1 saniyeden bir lock edecek hemde iki ferqli method
    // eyni zamanda basliyacaq lock etmeye araliglar eyni olacaq


    public void sendPaymentEmail() {

        schedulerService.sendPaymentEmail();
        Thread.sleep(5000L);//@SchedulerLock Min/Max vaxti deyise bilerik bu sekilde ;

    }


     */
}
