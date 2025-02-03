package az.ingress.acpects;

import az.ingress.annotations.TrackTime;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class ExecutionTimeAspect {

    @SneakyThrows
    @Around("@annotation(trackTime)")//Bu sekilde aspect etmek daha duzgundu yeni bize lazim olan methodalri gotursun;

    public Object trackTime(ProceedingJoinPoint joinPoint, TrackTime trackTime) {//joinPoint gedir Advice teyin edir ve,
        // arxa planda PointCut ve ya Around vastesile gedir methodu teyin edir;
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();//proceed(); methodu ise salir yeni bu olmasa aspect ise dusmuyecek;
        long elapsedTime = System.currentTimeMillis() - startTime;
        log.info("Execution time of : {} is {} ms", joinPoint.getSignature(), elapsedTime);
        //Buda bize methodun isleme vaxtini qaytarir;+ elapsedTime- startTime  sekildede yaza bilerik logda ;
        //getSignature() hansi methodun servicden ise dusduyunu gosterir;
        //Example ComputerService.getById methodunu ise salir ;

        return result;
        //En dogru sekilde rahat sekilde yazmaq annotations ile yazmaqdir basqa sekilde de yaza bilerik;
    }
/*
    @Pointcut("execution(* az.ingress.service.ComputerService.*(..))")//Yeni getsin ComputerServicde olan butun methodlari yeni cagirisin yada joinPoint elesin;
    public void serviceMethod (){

    }
    @SneakyThrows//Bunu yazmasaq wxception atacaq basqa sekilde throws ede bilerik exception;
    @Around(value = "serviceMethod ()")//Burada AfterReturning qeyd etsek void methodlarda islemez;
    //AfterThrowing bu exceptionlar ucun istifade edilir;
    //After-> methodun bitmesi;
    //Before-> methodun baslamasi;
    //After&Before ucun Around yazmaq en duzugun vaiantdi ve Before&After adeten loglamaq ucun istifade edilir;

    public Object elapsedTimeLogger(ProceedingJoinPoint jp) {

        long startDate = System.currentTimeMillis();
        Object response = jp.proceed();
        long endDate = System.currentTimeMillis();
        log.info("ElapsedTime :{}", endDate - startDate);
        return response;
    }


 */


}

