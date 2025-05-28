package com.example.WebServiceBasic.Repository;

import com.example.WebServiceBasic.Entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
