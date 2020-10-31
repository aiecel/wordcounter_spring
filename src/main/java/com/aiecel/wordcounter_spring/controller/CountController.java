package com.aiecel.wordcounter_spring.controller;

import com.aiecel.wordcounter_spring.model.Page;
import com.aiecel.wordcounter_spring.model.Word;
import com.aiecel.wordcounter_spring.util.html.FileHTMLWriter;
import com.aiecel.wordcounter_spring.util.html.HTMLDownloader;
import com.aiecel.wordcounter_spring.service.PageService;
import com.aiecel.wordcounter_spring.util.wordcounter.HTMLWordCounter;
import com.aiecel.wordcounter_spring.util.wordcounter.HTMLWordCounterFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Контроллер для подсчета слов на странице
 */
@Controller
public class CountController {
    private static final Logger logger = LoggerFactory.getLogger(CountController.class);

    private final PageService pageService;
    private final HTMLDownloader htmlDownloader;
    private final HTMLWordCounterFactory htmlWordCounterFactory;
    private final FileHTMLWriter htmlWriter;

    @Autowired
    public CountController(PageService pageService,
                           HTMLDownloader htmlDownloader,
                           HTMLWordCounterFactory htmlWordCounterFactory,
                           FileHTMLWriter htmlWriter) {
        this.pageService = pageService;
        this.htmlDownloader = htmlDownloader;
        this.htmlWordCounterFactory = htmlWordCounterFactory;
        this.htmlWriter = htmlWriter;
    }

    /**
     * Подсчитывает кол-во уникальных слов на странице и перенаправляет на /words
     * В случае возникновения ошибки перенаправляет на / с атрибутом errorMessage
     *
     * @param url адрес страницы для подсчета слов
     */
    @GetMapping(path = "/count")
    public ModelAndView countWordsOnPage(@RequestParam String url, RedirectAttributes redirectAttributes) {
        if (url == null || url.length() == 0) {
            redirectAttributes.addFlashAttribute("errorMessage", "Please specify the URL of the page");
            return new ModelAndView("redirect:/");
        }

        String html;
        try {
            //get html
            html = htmlDownloader.getHTMLFromUrl(new URL(url));
            logger.info("Downloaded HTML from {}", url);
        } catch (MalformedURLException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "URL is incorrect");
            logger.error("URL is incorrect: {}", url);
            return new ModelAndView("redirect:/");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Unable to get HTML: " + e.getMessage());
            logger.error("Unable to get HTML from URL {}: {}", url, e.getMessage());
            return new ModelAndView("redirect:/");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: " + e.getClass().getSimpleName() + ": " + e.getMessage());
            logger.error("Unexpected error");
            e.printStackTrace();
            return new ModelAndView("redirect:/");
        }

        //get counter and count words
        HTMLWordCounter wordCounter = htmlWordCounterFactory.getHTMLWordCounter();
        wordCounter.countInHTML(html);

        //construct page
        Page page = pageService.get(url).orElse(new Page(url));
        page.clearWords();

        //put counted words to page
        Collection<Word> countedWords = new ArrayList<>();
        logger.info("Counted words for url {}:", url);
        for (Map.Entry<String, Integer> wordOccurrences : wordCounter.getAllOccurrences().entrySet()) {
            countedWords.add(
                    new Word()
                            .setPage(page)
                            .setWord(wordOccurrences.getKey())
                            .setOccurrences(wordOccurrences.getValue())
            );
            logger.info("{}: {}", wordOccurrences.getKey(), wordOccurrences.getValue());
        }
        page.addAllWords(countedWords);

        //save page
        pageService.save(page);

        try {
            htmlWriter.save(url, html);
            logger.info("HTML saved to file {}", htmlWriter.getConverter().convert(url));
            redirectAttributes.addFlashAttribute("infoMessage", "HTML saved to " + htmlWriter.getConverter().convert(url));
        } catch (IOException e) {
            logger.error("Can't save HTML to file: {}", e.getMessage());
            redirectAttributes.addFlashAttribute("warningMessage", "Can't save HTML to file: " + e.getMessage());
        }

        redirectAttributes.addAttribute("url", url);
        return new ModelAndView("redirect:/words");
    }
}
