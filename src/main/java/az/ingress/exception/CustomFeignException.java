package az.ingress.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomFeignException extends RuntimeException {
    // Xəta mesajı
    private final int status;
    private String code;

    public CustomFeignException(String message, int status,String code) {
        super(message);
        this.status = status;
        this.code=code;

    }


}
