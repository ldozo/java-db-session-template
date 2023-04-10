package com.enginaar.sessionauthtemplate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.enginaar.sessionauthtemplate.entity.City;
import com.enginaar.sessionauthtemplate.repository.CityRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CityService {

    private CityRepository citiRepo;
    
    public List<City> list() {
        return citiRepo.findAll();
    }

    public void add(City city) {
        Optional<City> existed = citiRepo.findByName(city.getName());
        Assert.isTrue(existed.isEmpty(), "City already existed");
        citiRepo.save(city);
    }

    public void delete(long id) {
        City existed = findById(id);
        citiRepo.delete(existed);
    }

    public City findById(long id) {
        Optional<City> existed = citiRepo.findById(id);
        Assert.isTrue(existed.isPresent(), "City not found");
        return existed.get();
    }

}
