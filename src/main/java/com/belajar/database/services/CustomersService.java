package com.belajar.database.services;

import com.belajar.database.model.CustomersModel;
import com.belajar.database.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {

    @Autowired
    private CustomersRepository customersRepository;

    public List<CustomersModel> getAllCustomers() {
        return customersRepository.findAll();
    }

    public Optional<CustomersModel> getCustomersById(Long id) {
        return customersRepository.findById(id);
    }

    public CustomersModel createCustomer(CustomersModel customer) {
        return customersRepository.save(customer);
    }

    public void deleteCutomer(Long id) {
        customersRepository.deleteById(id);
    }
}
