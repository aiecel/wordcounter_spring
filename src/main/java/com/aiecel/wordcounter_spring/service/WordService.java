package com.aiecel.wordcounter_spring.service;

import com.aiecel.wordcounter_spring.model.Word;

import java.util.List;

/**
 * Сервис для работы со словами
 */
public interface WordService {
    /**
     * Возвращает список всех слов, отсортированный по кол-ву вхождений
     */
    List<Word> getAllSortedByOccurrences();

    /**
     * Возвращает список всех слов на странице с заданным URL, отсортированный по кол-ву вхождений
     *
     * @param url url страницы
     */
    List<Word> getAllByUrlSortedByOccurrences(String url);
}
