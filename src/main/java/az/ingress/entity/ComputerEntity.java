package az.ingress.entity;

import az.ingress.model.enums.ComputerStatus;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "computer")
@Entity
@Builder
@FieldNameConstants

public class ComputerEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String computerMark;
    private BigDecimal amount;
    private LocalDate date;
    @Enumerated(value = EnumType.STRING)
    private ComputerStatus status;
    @Version//OL istifade etmek ucun;
    //OL-da version uzerinde locking gedir yeni eyni anda version 1 olan datanin amount eyni anda ferqli-ferqli set olsa bu zaman evvel hansi set olsa o save olacaq ikinci ise,
    //Exception atacaq ve lock hala dusecek ta ki locking bitenden sonra set edib save ede biler + r-trey edemek lazimdir ,
    //Bu Optimistic Locking adlanir;
    //Version automatic deyisir;
    private Long version;
}

