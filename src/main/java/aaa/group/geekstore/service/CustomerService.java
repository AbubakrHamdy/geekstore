package aaa.group.geekstore.service;

import aaa.group.geekstore.model.Customer;
import aaa.group.geekstore.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getById(UUID id) {
        return customerRepository.findById(id);
    }

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer update(UUID id, Customer customer) {
        customer.setId(id);
        return customerRepository.save(customer);
    }

    public void deleteById(UUID id) {
        customerRepository.deleteById(id);
    }
}
