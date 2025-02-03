package az.ingress.acpects;

import az.ingress.annotations.LogExecution;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class ExecutionLoggingAspect {

    @SneakyThrows
    @Around("@annotation(logExecution)")
    public Object logExecution(ProceedingJoinPoint jp, LogExecution logExecution) {
        log.info("Method {} started with arguments: {}", jp.getSignature(), jp.getArgs());//Methodun parameterlerini qayatarir;
        Object logy = jp.proceed();
        log.info("Method {} finished with result: {}", jp.getSignature(),logy);
        return logy;
        //Logging basqa sekilde yaza bilerik ;
    }
    /*
    //Bu sekilde de logging yaza bilerik ;
    @Pointcut("execution(* az.ingress.service.ComputerService.*(..))")
    public void logTest() {
    }


    @Before(value = "logTest()")
    public void logBeforeExecutionLogging(ProceedingJoinPoint joinPoint) {

        log.info("Method starting:{}", joinPoint.getSignature().getName());//Method Name qaytarir;
    }

    @After(value = "logTest()")
    public void logAfterExecutionLogging(ProceedingJoinPoint joinPoint) {

        log.info("Method end : {}", joinPoint.getSignature().getName());
    }

     */
}
