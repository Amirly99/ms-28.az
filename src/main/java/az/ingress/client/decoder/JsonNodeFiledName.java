package az.ingress.client.decoder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum JsonNodeFiledName {
//CODE("code");

    MESSAGE("message") ;



    private final String value;
}
