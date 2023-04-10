package com.enginaar.sessionauthtemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.enginaar.sessionauthtemplate.entity.District;
import com.enginaar.sessionauthtemplate.service.CityService;
import com.enginaar.sessionauthtemplate.service.DistrictService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/app/city")
@AllArgsConstructor
public class DistrictController {

    private DistrictService districts;
    private CityService cities;
    private CityController cityController;

    @GetMapping("/{cityId}/district/new")
    public ModelAndView newForm(@PathVariable long cityId) {
        var city = cities.findById(cityId);
        var mv = new ModelAndView();
        var district = new District();
        district.setCity(city);
        mv.addObject("district", district);
        mv.setViewName("district/form");
        return mv;
    }

    @GetMapping("/{cityId}/district/{id}")
    public ModelAndView get(@PathVariable long cityId, @PathVariable long id) {
        var mv = new ModelAndView();
        var existed = districts.findById(id);
        Assert.isTrue(existed.getCity().getId() == cityId, "City/District do not match");
        mv.addObject("district", existed);
        mv.setViewName("district/form");
        return mv;
    }

    @PostMapping("/district")
    public ModelAndView add(District district) {
        var result = districts.add(district);
        return cityController.get(result.getCity().getId());
    }

    @GetMapping("/{cityId}/district/{id}/delete")
    public ModelAndView delete(@PathVariable long cityId, @PathVariable long id){
        districts.delete(cityId, id);
        return cityController.get(cityId);
    }
}
