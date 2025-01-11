package az.ingress.config;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

@Configuration//Sade bean yaradilmasi;
@EnableScheduling//Scheduler aktiv olunmasi ucun ;
@EnableSchedulerLock(defaultLockAtMostFor = "PT1S")//MAX iseleme vaxtidi yeni 1 satdan bir tekrar prossesin gedilmesi;
public class SchedulerConfig {
    @Bean//method oldugu ucun;
    public LockProvider lockProvider(DataSource dataSource) {
        return new JdbcTemplateLockProvider(dataSource);


    }


}
