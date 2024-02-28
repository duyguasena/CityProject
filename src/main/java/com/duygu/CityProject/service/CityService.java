package com.duygu.CityProject.service;

import com.duygu.CityProject.model.City;
import com.duygu.CityProject.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CityService {
    private  final CityRepository cityRepository;

    public City createCity(City newCity) {
        newCity.setCreatedDate(new Date());
        return  cityRepository.save(newCity);

    }

    public List<City> getCities(String name) {
        if(Objects.isNull(name)){
            return cityRepository.findAll();
        }else
            return cityRepository.findAllByName(name);
    }

    public City getCity(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Id bulunamadı"));
    }

    public String deleteCity(Long id){
        City city=cityRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Id bulunamadı"));
        cityRepository.delete(city);
        return "İşlem başarılı";

    }

    public City updateCity(Long id, City newCity) {
        City oldCity=cityRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Id bulunamadı"));
        oldCity.setName(newCity.getName());
        return cityRepository.save(oldCity);
    }
}
