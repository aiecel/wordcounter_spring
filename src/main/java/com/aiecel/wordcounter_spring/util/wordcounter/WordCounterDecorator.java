package com.aiecel.wordcounter_spring.util.wordcounter;

import java.util.Map;

/**
 * Абстрактный класс декораторов для {@link WordCounter}
 */
public abstract class WordCounterDecorator implements WordCounter {
    private final WordCounter wordCounter;

    public WordCounterDecorator(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    /**
     * Инкрементирует кол-во вхождений слова
     *
     * @param word слово
     */
    public void count(String word) {
        wordCounter.count(word);
    }

    /**
     * Возвращает кол-во вхождений слова
     *
     * @param word слово
     * @return кол-во вхождений слова
     */
    public int getOccurrences(String word) {
        return wordCounter.getOccurrences(word);
    }

    /**
     * Возвращает все подсчитанные слова и кол-во их подсчитанных вхождений
     *
     * @return подсчитанные слова и кол-во их подсчитанных вхождений
     */
    public Map<String, Integer> getAllOccurrences() {
        return wordCounter.getAllOccurrences();
    }
}
