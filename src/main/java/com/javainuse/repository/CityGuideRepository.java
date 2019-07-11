package com.javainuse.repository;

import com.javainuse.model.CityGuide;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityGuideRepository extends CrudRepository<CityGuide, String> {
    CityGuide getCityGuideByCity(String city);
    boolean existsByCity(String city);
}
