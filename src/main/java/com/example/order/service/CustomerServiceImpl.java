package com.example.order.service;

import com.example.order.entity.Customer;
import com.example.order.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {

        Optional<Customer> optCustomer = customerRepository.findById(customer.getId());

        if (optCustomer.isPresent()) {
            Customer oCustomer = optCustomer.get();
            BeanUtils.copyProperties(customer, oCustomer);
            return customerRepository.save(oCustomer);
        }
        return this.save(customer);
    }

    @Override
    public Customer updatePartial(Customer customer) {

        Optional<Customer> optCustomer = customerRepository.findById(customer.getId());
        if (optCustomer.isPresent()) {
            Customer oCustomer = optCustomer.get();
            oCustomer.setName(customer.getName());
            oCustomer.setLastname(customer.getLastname());
            oCustomer.setAge(customer.getAge());
            oCustomer.setDate_of_birth(customer.getDate_of_birth());
            return customerRepository.save(oCustomer);
        }
        throw new RuntimeException("No existe customer con el id=" + customer.getId());
    }

    @Override
    public void delete(Long id) {

    }
}
