package az.ingress.model.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageCriteria {
    private Integer page;//page number start in 0//Yeni page sayi meselen 1 versek bu zaman page 1 qaytaracaq;
    //0 versek butun page qaytaracaq;
    private Integer count;//Burda ise sayi di yeni necedene 1 sehifeden ibaret melumatlar var;
}
