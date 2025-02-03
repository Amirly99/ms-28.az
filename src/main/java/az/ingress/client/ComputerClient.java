package az.ingress.client;

import az.ingress.client.decoder.CustomErrorDecoder;
import az.ingress.model.client.ComputerResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "ms-computer",
        url = "http://localhost:8092",
        configuration = CustomErrorDecoder.class


)
public interface ComputerClient {

    @GetMapping("/internal/v1/computers/{id}")
    ComputerResponseDto getComputer(@PathVariable("id") Long id);
    //DTO -> Data Transfer Object;

    //API qebul edilen zaman class ->  Request olur;
    //API qaytaran zaman class -> Response olur;
    //Microservice aralarinda mubadile zamani class -> DTO olur;
    //Iki microservice arasinda mubadile bas veren zaman client microservice daim private olur yeni security saxlanilmaldi;
    //internal/v1/computers ise yanliz hansi microservice ile arasinda mubadile gedirse o gore biler ve sorgu gondere biler yeni normalda private olur;
    //Diger microservice her zaman public olaraq qalir yeni v1/computers ile gonderilen burun sorgular public olur hem fronted hem mobile ve s ucun;

}
