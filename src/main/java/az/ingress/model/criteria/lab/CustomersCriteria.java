package az.ingress.model.criteria.lab;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CustomersCriteria {
    private  String pin;
    private String phoneNumber;
    private String fullName;



}
