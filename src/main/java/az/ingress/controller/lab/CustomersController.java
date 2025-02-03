package az.ingress.controller.lab;

import az.ingress.model.criteria.lab.CustomersCriteria;
import az.ingress.model.criteria.PageCriteria;
import az.ingress.response.PageableResponse;
import az.ingress.response.lab.CustomersResponse;
import az.ingress.service.lab.CustomersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/customers")
public class CustomersController {
    private final CustomersService customersService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody CustomersResponse customersResponse) {
        customersService.create(customersResponse);
    }

    @GetMapping()
    public PageableResponse getCustomers(PageCriteria pageCriteria, CustomersCriteria customersCriteria) {
        return customersService.getCustomers(customersCriteria, pageCriteria);
    }


}
