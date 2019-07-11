package com.javainuse.service;

import com.javainuse.model.CityGuide;

import java.util.List;

public interface CityGuideService {
    boolean existsByCity(String city);
    CityGuide create(CityGuide cityGuide);
    CityGuide getCityGuideByCity(String city);
    CityGuide update(CityGuide cityGuide);
    List<CityGuide> getAllCityGuides();
    void delete(String id);
}
