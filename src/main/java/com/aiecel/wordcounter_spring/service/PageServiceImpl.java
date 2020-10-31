package com.aiecel.wordcounter_spring.service;

import com.aiecel.wordcounter_spring.model.Page;
import com.aiecel.wordcounter_spring.repository.PageRepository;
import com.aiecel.wordcounter_spring.repository.WordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Сервис работы со страницами
 */
@Service
public class PageServiceImpl implements PageService {
    private final PageRepository pageRepository;
    private final WordRepository wordRepository;

    @Autowired
    public PageServiceImpl(PageRepository pageRepository, WordRepository wordRepository) {
        this.pageRepository = pageRepository;
        this.wordRepository = wordRepository;
    }

    /**
     * Возвращает страницу по её url
     *
     * @param url url страницы
     */
    public Optional<Page> get(String url) {
        return pageRepository.findByUrl(url);
    }

    /**
     * Сохраняет страницу
     */
    @Override
    @Transactional
    public void save(Page page) {
        pageRepository.save(page);
        wordRepository.saveAll(page.getWords());
    }
}
