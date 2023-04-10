package com.enginaar.sessionauthtemplate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.enginaar.sessionauthtemplate.entity.City;
import com.enginaar.sessionauthtemplate.entity.TransactionLog;
import com.enginaar.sessionauthtemplate.repository.CityRepository;
import com.enginaar.sessionauthtemplate.repository.LogRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CityService {

    private CityRepository citiRepo;
    private LogService logs;
    
    public List<City> list() {
        return citiRepo.findAll();
    }

    @Transactional
    public void add(City city) {
        Optional<City> existed = citiRepo.findByName(city.getName());
        Assert.isTrue(existed.isEmpty(), "City already existed");
        var saved = citiRepo.save(city);
        if(city.getId() == null)
            logs.add("city.added", city.toString());
        else {
            logs.add("city.updated", city.toString(), saved.toString());
        }
    }

    @Transactional
    public void delete(long id) {
        City existed = findById(id);
        logs.add("city.removed", existed.toString());
        citiRepo.delete(existed);
    }

    public City findById(long id) {
        Optional<City> existed = citiRepo.findById(id);
        Assert.isTrue(existed.isPresent(), "City not found");
        return existed.get();
    }

}
