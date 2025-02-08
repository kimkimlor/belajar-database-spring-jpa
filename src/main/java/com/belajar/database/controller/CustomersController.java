package com.belajar.database.controller;

import com.belajar.database.model.CustomersModel;
import com.belajar.database.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    private CustomersService cs;

    @GetMapping
    public List<CustomersModel> getAllCustomers() {
        return cs.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Optional<CustomersModel> getCustomerById(@PathVariable Long id) {
        return cs.getCustomersById(id);
    }

    @PostMapping
    public CustomersModel createCustomer(@RequestBody CustomersModel customer) {
        return cs.createCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        cs.deleteCutomer(id);
    }
}
