package com.enginaar.sessionauthtemplate.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.enginaar.sessionauthtemplate.entity.District;
import com.enginaar.sessionauthtemplate.repository.DistrictRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DistrictService {

    private DistrictRepository distRepo;

    public District findById(long id) {
        var existed = distRepo.findById(id);
        Assert.isTrue(existed.isPresent(), "District not found");
        return existed.get();
    }

    public District add(District district) {
        var saved = distRepo.save(district);
        return saved;
    }


    public void delete(long cityId, long id) {
        var existed = findById(id);
        Assert.isTrue(existed.getCity().getId() == cityId, "City/District do not match");
        distRepo.delete(existed);
    }

}
