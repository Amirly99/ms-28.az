package az.ingress.client.decoder;

import az.ingress.exception.CustomFeignException;
import az.ingress.exception.ExceptionConstants;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import static az.ingress.client.decoder.JsonNodeFiledName.MESSAGE;

@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey,
                            Response response) {

        var errorMessage = ExceptionConstants.CLIENT_ERROR;
       // var errorCode = ExceptionConstants.CLIENT_ERROR;     // Default error code
        int errorStatus = response.status();

        JsonNode jsonNode;
        try (var body = response.body().asInputStream()) {

            jsonNode = new ObjectMapper().readValue(body, JsonNode.class);
        } catch (Exception e) {

            throw new CustomFeignException(errorMessage, response.status(), ExceptionConstants.CLIENT_ERROR);
        }
        if (jsonNode.has(MESSAGE.getValue())) {

            errorMessage = jsonNode.get(MESSAGE.getValue()).asText();

        }
        if (jsonNode.has("code")) {
            errorMessage = jsonNode.get("code").asText();
        }


        if (jsonNode.has("status")) {
            errorStatus = jsonNode.get("status").asInt();
        }

        log.error("ActionLog.decode.error Message:{},Method :{} ", errorMessage, methodKey);

        return new CustomFeignException(errorMessage, response.status(), errorMessage);
    }
}
