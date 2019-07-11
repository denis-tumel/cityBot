package com.javainuse.service.impl;

import com.javainuse.model.CityGuide;
import com.javainuse.repository.CityGuideRepository;
import com.javainuse.service.CityGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityGuideServiceImpl implements CityGuideService {

    private final CityGuideRepository repository;

    @Autowired
    public CityGuideServiceImpl(CityGuideRepository repository){
        this.repository = repository;
    }

    @Override
    public boolean existsByCity(String city){
        return repository.existsByCity(city);
    }

    @Override
    public CityGuide create(CityGuide cityGuide) {
        return repository.save(cityGuide);
    }

    @Override
    public CityGuide getCityGuideByCity(String city) {
        return repository.getCityGuideByCity(city);
    }

    @Override
    public CityGuide update(CityGuide cityGuide) {
        return repository.save(cityGuide);
    }

    @Override
    public List<CityGuide> getAllCityGuides() {
        return (List<CityGuide>) repository.findAll();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
