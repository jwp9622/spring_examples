package com.example.WebServiceBasic.Controller;

import com.example.WebServiceBasic.Entity.Coffee;
import com.example.WebServiceBasic.Repository.CoffeeRepository;
import com.example.WebServiceBasic.dto.CoffeeForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coffees")
public class CoffeeController {
    private final CoffeeRepository coffeeRepository;

    public CoffeeController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }
    //전체 목록
    @GetMapping
    public List<Coffee> getAllCoffees(){
        return coffeeRepository.findAll();
    }
    //상세내용
    @GetMapping("{id}")
    public ResponseEntity<Coffee> getCoffee(@PathVariable Long id){
        return coffeeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    //생성
    @PostMapping
    public Coffee createCoffee(@RequestBody CoffeeForm dto){
        Coffee coffee = new Coffee();
        coffee.setName(dto.getName());
        coffee.setPrice(dto.getPrice());
        return coffeeRepository.save(coffee);
    }
    //수정
    @PatchMapping("{id}")
    public ResponseEntity<Coffee> updateCoffee(@PathVariable Long id,
                                            @RequestBody CoffeeForm dto){
        return coffeeRepository.findById(id)
                .map(coffee ->{
                    coffee.setName(dto.getName());
                    coffee.setPrice(dto.getPrice());
                    coffeeRepository.save(coffee);
                    return ResponseEntity.ok(coffee);
                }).orElse(ResponseEntity.notFound().build());
    }

    //삭제
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCoffee(@PathVariable Long id){
        return coffeeRepository.findById(id)
                .map(coffee ->{
                    coffeeRepository.delete(coffee);
                    return ResponseEntity.noContent().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
