package az.ingress.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static az.ingress.exception.ExceptionConstants.UNEXPECTED_EXCEPTION_CODE;
import static az.ingress.exception.ExceptionConstants.UNEXPECTED_EXCEPTION_MESSAGE;

@RestControllerAdvice//Ex handler bu sekilde Spring Boot istifade olunur yeni ise dusur;
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(Exception.class)//Namelum ex bas verdikde bu ex atacaq en pis halda;
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handle(Exception ex) {
        log.error("Exception", ex);
        return new ExceptionResponse(UNEXPECTED_EXCEPTION_CODE, UNEXPECTED_EXCEPTION_MESSAGE);//Bura hard code yazmagin sebbebi odu ki ex ->
        //bas verdikde musteri terefden anlasilan ex olsun yoxsa message gondersek exp musteri basa dusmez yene mesel:NotFoundException;
        //Ex paralel handler etmeyin hemde diger ustunluyu odu ki,esas exception handler sehven etsek onun evezine Exception.class onun evezine partlasin;
        //Biz servicde ferqli-ferqli exp qeyd etmisikse o zaman butun exp handler etmeliyik;
    }

    @ExceptionHandler(NotFoundException.class)//NotFound ex handler etdikde normalda ayri ex bas verse bu zaman;
    //Axdarcaq NFE hardan yaranmasini gedib RT ex goturecek bu zaman RT ex tapmasa ,sonda gelib Exception ozunu tapacaq;
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handle(NotFoundException ex) {

        log.error("NotFoundException", ex);
        return new ExceptionResponse(ex.getCode(), ex.getMessage());
    }
}
