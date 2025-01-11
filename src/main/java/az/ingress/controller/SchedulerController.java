package az.ingress.controller;

import az.ingress.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "v1/scheduler")
public class SchedulerController {
    private final SchedulerService schedulerService;
/*
    @PostMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void saveScheduler() {
        schedulerService.saveScheduler();
    }

 */
}
