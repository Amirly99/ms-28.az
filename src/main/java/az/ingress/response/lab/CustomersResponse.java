package az.ingress.response.lab;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomersResponse {
    private String  pin;
    private String fullName;
    private String phoneNumber;
}
