package com.enginaar.sessionauthtemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.enginaar.sessionauthtemplate.entity.City;
import com.enginaar.sessionauthtemplate.service.CityService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/app/city")
@AllArgsConstructor
public class CityController {

    private CityService cities;

    @GetMapping
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("cities", cities.list());
        mv.setViewName("city/list");
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView newForm() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("city", new City());
        mv.setViewName("city/form");
        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable long id) {
        ModelAndView mv = new ModelAndView();
        City existed = cities.findById(id);
        mv.addObject("city", existed);
        mv.setViewName("city/form");
        return mv;
    }

    @PostMapping
    public ModelAndView add(City city) {
        cities.add(city);
        return list();
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable long id) {
        cities.delete(id);
        return list();
    }
}
