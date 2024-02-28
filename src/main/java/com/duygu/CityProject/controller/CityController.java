package com.duygu.CityProject.controller;



import com.duygu.CityProject.model.City;
import com.duygu.CityProject.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @PostMapping
    public City createCity(@RequestBody City newCity){
        return  cityService.createCity(newCity);
    }
    @GetMapping
    public List<City> getCities(@RequestParam(required = false) String name){
        return cityService.getCities(name);
    }

    @GetMapping("{id}")
    public City getCity(@PathVariable Long id){
        return cityService.getCity(id);
    }

    @DeleteMapping("{id}")
    public String deleteCity(@PathVariable Long id){
        return cityService.deleteCity(id);
    }

    @PutMapping("{id}")
    public City updateCity(@PathVariable Long id,@RequestBody City newCity) {
        return  cityService.updateCity(id,newCity);
    }


}
