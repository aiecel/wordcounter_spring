package com.aiecel.wordcounter_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Контроллер главной страницы
 */
@Controller
public class HomeController {

    /**
     * Отображает главную страницу
     *
     * @param errorMessage сообщение об ошибке
     */
    @GetMapping(path = "/")
    public ModelAndView homePage(@RequestParam(required = false) String errorMessage) {
        ModelAndView modelAndView = new ModelAndView("index");
        if (errorMessage != null && errorMessage.length() > 0) {
            modelAndView.addObject("errorMessage", errorMessage);
        }
        return modelAndView;
    }
}
