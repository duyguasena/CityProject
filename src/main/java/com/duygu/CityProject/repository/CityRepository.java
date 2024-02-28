package com.duygu.CityProject.repository;

import com.duygu.CityProject.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Long> {
    List<City> findAllByName(String name);
}
