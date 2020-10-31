package com.aiecel.wordcounter_spring.service;

import com.aiecel.wordcounter_spring.model.Page;

import java.util.Optional;

/**
 * Сервис работы со страницами
 */
public interface PageService {
    /**
     * Возвращает страницу по её url
     *
     * @param url url страницы
     */
    Optional<Page> get(String url);

    /**
     * Сохраняет страницу
     */
    void save(Page page);
}
