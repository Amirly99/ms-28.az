package az.ingress.service.lab;

import az.ingress.model.criteria.lab.CustomersCriteria;
import az.ingress.model.criteria.PageCriteria;
import az.ingress.response.PageableResponse;
import az.ingress.response.lab.CustomersResponse;


public interface CustomersService {

    void create(CustomersResponse customersResponse);
    PageableResponse getCustomers(CustomersCriteria customersCriteria, PageCriteria pageCriteria);
}
