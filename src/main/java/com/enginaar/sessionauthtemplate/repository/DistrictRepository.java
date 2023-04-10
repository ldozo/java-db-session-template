package com.enginaar.sessionauthtemplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enginaar.sessionauthtemplate.entity.District;

public interface DistrictRepository extends JpaRepository<District, Long> {

    void findByCityId(long city);

}
