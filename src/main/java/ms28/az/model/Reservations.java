package ms28.az.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservations {

    private String tableName;
    private String customerName;
    private String status;
    private int count_members;

}
