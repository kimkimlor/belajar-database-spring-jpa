package com.belajar.database.repository;

import com.belajar.database.model.CustomersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<CustomersModel, Long> {
    // udah didefinisiin query CRUDnya sama si SPRING DATA JPA
}
