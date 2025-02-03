package az.ingress.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class NotFoundException extends RuntimeException {
    private final int status ;
    private String code;


    public NotFoundException(String message, String code) {
        super(message);
        this.code = code;
        this.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }


}
