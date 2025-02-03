package az.ingress;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EnableAsync
@EnableCaching
@EnableJpaRepositories(basePackages = "az.ingress.repository")
@EnableScheduling
@EnableFeignClients

public class Application {

    public static void main(String[] args) {
        run(Application.class, args);
    }
}