package com.aiecel.wordcounter_spring.service;

import com.aiecel.wordcounter_spring.model.Word;
import com.aiecel.wordcounter_spring.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для работы со словами
 */
@Service
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;

    @Autowired
    public WordServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    /**
     * Возвращает список всех слов, отсортированный по кол-ву вхождений
     */
    @Override
    public List<Word> getAllSortedByOccurrences() {
        return wordRepository.findAllOrderByOccurrencesDesc();
    }

    /**
     * Возвращает список всех слов на странице с заданным URL, отсортированный по кол-ву вхождений
     *
     * @param url url страницы
     */
    @Override
    public List<Word> getAllByUrlSortedByOccurrences(String url) {
        return wordRepository.findAllByUrlOrderByOccurrencesDesc(url);
    }
}
