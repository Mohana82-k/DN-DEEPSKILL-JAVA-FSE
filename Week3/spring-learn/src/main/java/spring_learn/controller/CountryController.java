package spring_learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import spring_learn.model.Country;

@RestController
public class CountryController {

    @GetMapping("/country/{code}")
    public Country getCountry(@PathVariable String code) {

        Country country = new Country();

        if(code.equalsIgnoreCase("IN")) {
            country.setCode("IN");
            country.setName("India");
        }
        else if(code.equalsIgnoreCase("US")) {
            country.setCode("US");
            country.setName("United States of America");
        }
        else {
            country.setCode(code);
            country.setName("Country Not Found");
        }

        return country;
    }
}