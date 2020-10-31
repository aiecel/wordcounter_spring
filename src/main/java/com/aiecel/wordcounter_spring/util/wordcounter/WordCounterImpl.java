package com.aiecel.wordcounter_spring.util.wordcounter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Счетчик уникальных слов
 */
public class WordCounterImpl implements WordCounter {
    private static final Logger logger = LoggerFactory.getLogger(WordCounterImpl.class.getSimpleName());

    private final Map<String, Integer> wordsOccurrences;

    public WordCounterImpl() {
        this.wordsOccurrences = new HashMap<>();
    }

    /**
     * Инкрементирует кол-во вхождений слова
     *
     * @param word слово
     */
    public void count(String word) {
        String wordLowerCase = word.toLowerCase();
        if (wordsOccurrences.containsKey(wordLowerCase)) {
            wordsOccurrences.put(wordLowerCase, wordsOccurrences.get(wordLowerCase) + 1);
        } else {
            wordsOccurrences.put(wordLowerCase, 1);
        }
        logger.debug("{} : occurrence counted", word);
    }

    /**
     * Возвращает кол-во вхождений слова
     *
     * @param word слово
     * @return кол-во вхождений слова
     */
    public int getOccurrences(String word) {
        if (wordsOccurrences.containsKey(word.toLowerCase())) return wordsOccurrences.get(word.toLowerCase());
        return 0;
    }

    /**
     * Возвращает все подсчитанные слова и кол-во их подсчитанных вхождений
     *
     * @return подсчитанные слова и кол-во их подсчитанных вхождений
     */
    public Map<String, Integer> getAllOccurrences() {
        return wordsOccurrences;
    }
}
