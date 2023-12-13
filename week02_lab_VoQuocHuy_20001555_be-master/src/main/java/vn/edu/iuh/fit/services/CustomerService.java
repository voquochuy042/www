package vn.edu.iuh.fit.services;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class CustomerService {
    @Inject
    CustomerRepository customerRepository;
    public List<Customer> getAllCustomer(int p){
        return customerRepository.getAllCustomer(p);
    }

    public boolean add(Customer customer) {
        return customerRepository.add(customer);
    }
    public Optional<Boolean> update(Customer customer) {
        Optional<Customer> optional = findById(customer.getId());

        if (optional.isEmpty())
            return Optional.empty();

        return Optional.of(customerRepository.update(customer));
    }
    public Optional<Customer> findById(long id){
        return customerRepository.findById(id);
    }

}
