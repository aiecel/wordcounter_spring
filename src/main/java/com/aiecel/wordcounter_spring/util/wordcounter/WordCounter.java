package com.aiecel.wordcounter_spring.util.wordcounter;

import java.util.Map;

/**
 * Интерфейс для классов подсчета кол-ва уникальных слов
 */
public interface WordCounter {
    /**
     * Инкрементирует кол-во вхождений слова
     *
     * @param word слово
     */
    void count(String word);

    /**
     * Возвращает кол-во вхождений слова
     *
     * @param word слово
     * @return кол-во вхождений слова
     */
    int getOccurrences(String word);

    /**
     * Возвращает все подсчитанные слова и кол-во их подсчитанных вхождений
     *
     * @return подсчитанные слова и кол-во их подсчитанных вхождений
     */
    Map<String, Integer> getAllOccurrences();
}
