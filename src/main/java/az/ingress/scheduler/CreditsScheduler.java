package az.ingress.scheduler;

import az.ingress.service.lab.CreditsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j

public class CreditsScheduler {

    private final CreditsService creditsService;
   // @Scheduled(fixedRate = 3600000)//Her saatdan bir ise dusecek;
    @Scheduled(cron = "0 0 0 * * ?")//Her gece saat 00:00-da ise dusecek;
    public void runCreditStatusUpdate() {
        log.info("Running credit status update job..");
        creditsService.updateExpiredCredits();
    }
}
