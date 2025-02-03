package az.ingress.acpects;

import az.ingress.annotations.HandleException;
import az.ingress.exception.NotFoundException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class ExecutionExceptionHandlerAspect {
    @SneakyThrows
    @Around(value = "@annotation(handleException)")
    public Object handleExecution(ProceedingJoinPoint jp, HandleException handleException) {

        try {
            return jp.proceed();
        } catch (NotFoundException exception) {//Eger NFE-sa eyni ile otur;

            log.error("NotFoundException in method {}: {} ", jp.getSignature(), exception.getMessage());
            throw exception;// Xettani oldugu kimi otur;
        } catch (Exception e) {//Namelum xetta cixdigda Exception message atsin;

            log.error("Exception in method {}: {}", jp.getSignature(), e.getMessage());

            throw new RuntimeException("Not found ");

        }


    }
}