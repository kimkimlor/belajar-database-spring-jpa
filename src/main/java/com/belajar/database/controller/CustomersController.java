package com.belajar.database.controller;

import com.belajar.database.model.CustomersModel;
import com.belajar.database.repository.CustomersRepository;
import com.belajar.database.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    private CustomersService cs;

    @GetMapping
    public String getAllCustomers(Model model) {
        List<CustomersModel> customersList = cs.getAllCustomers();
        model.addAttribute("allCustomers", customersList);
        return "index"; // Ini akan mencari file src/main/resources/templates/index.html
    }

    @GetMapping("/{id}")
    public Optional<CustomersModel> getCustomerById(@PathVariable Long id) {
        return cs.getCustomersById(id);
    }

    @PostMapping
    public CustomersModel createCustomer(@RequestBody CustomersModel customer) {
        return cs.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomersModel> updateCustomer(
            @PathVariable Long id,
            @RequestBody CustomersModel customer
    ) {
        CustomersModel updatedCustomer = cs.updateCustomer(id, customer.getName(), customer.getEmail());
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        cs.deleteCustomer(id);
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Mengembalikan template login.html
    }
}
