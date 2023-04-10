package com.enginaar.sessionauthtemplate.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.enginaar.sessionauthtemplate.entity.District;
import com.enginaar.sessionauthtemplate.repository.DistrictRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DistrictService {

    private DistrictRepository distRepo;
    private LogService logs;

    public District findById(long id) {
        var existed = distRepo.findById(id);
        Assert.isTrue(existed.isPresent(), "District not found");
        return existed.get();
    }

    @Transactional
    public District add(District district) {
        var saved = distRepo.save(district);
        if(district.getId() == null)
            logs.add("district.added", district.toString());
        else {
            logs.add("district.updated", district.toString(), saved.toString());
        }
        return saved;
    }

    @Transactional
    public void delete(long cityId, long id) {
        var existed = findById(id);
        Assert.isTrue(existed.getCity().getId() == cityId, "City/District do not match");
        distRepo.delete(existed);
        logs.add("district.removed", existed.toString());
    }

}
