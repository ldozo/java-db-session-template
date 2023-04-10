package com.enginaar.sessionauthtemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.enginaar.sessionauthtemplate.entity.City;
import com.enginaar.sessionauthtemplate.service.CityService;
import com.enginaar.sessionauthtemplate.service.TransactionLogService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/app/transactions")
@AllArgsConstructor
public class LoggingController {

    private TransactionLogService logs;

    @GetMapping
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("transactions", logs.list());
        mv.setViewName("logs/list");
        return mv;
    }
}
