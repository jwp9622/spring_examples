package com.example.WebServiceBasic.dto;

import com.example.WebServiceBasic.Entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class CoffeeDto {
    private int id;
    private String name;
    private String price;

    public Coffee toEntity(){
        return new Coffee(id, name, price);
    }
}
