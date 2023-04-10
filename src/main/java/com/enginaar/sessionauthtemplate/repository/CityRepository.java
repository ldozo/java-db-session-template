package com.enginaar.sessionauthtemplate.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enginaar.sessionauthtemplate.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findByName(String name);

}
