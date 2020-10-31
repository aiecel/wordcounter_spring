package com.aiecel.wordcounter_spring.controller;

import com.aiecel.wordcounter_spring.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Контроллер для показа кол-ва уникальных слов
 */
@Controller
public class WordController {
    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    /**
     * Отображает таблицу подсчитанных уникальных слов на странице
     *
     * @param url url страницы, для которой показываются подсчитанные слова
     * @param infoMessage информационное сообщение
     * @param warningMessage сообщение-предупреждение
     */
    @GetMapping(path = "/words")
    public ModelAndView getWordsByUrl(
            @RequestParam String url,
            @RequestParam(required = false) String infoMessage,
            @RequestParam(required = false) String warningMessage) {
        ModelAndView modelAndView = new ModelAndView("words");
        modelAndView.addObject("pageUrl", url);
        modelAndView.addObject("words", wordService.getAllByUrlSortedByOccurrences(url));

        //add info message if it exists
        if (infoMessage != null && infoMessage.length() > 0) {
            modelAndView.addObject("infoMessage", infoMessage);
        }

        //add warning message if it exists
        if (warningMessage != null && warningMessage.length() > 0) {
            modelAndView.addObject("warningMessage", warningMessage);
        }

        return modelAndView;
    }

    /**
     * Отображает общую таблицу подсчитанных слов
     */
    @GetMapping(path = "/all")
    public ModelAndView getAllWords() {
        ModelAndView modelAndView = new ModelAndView("allWords");
        modelAndView.addObject("words", wordService.getAllSortedByOccurrences());
        return modelAndView;
    }
}
