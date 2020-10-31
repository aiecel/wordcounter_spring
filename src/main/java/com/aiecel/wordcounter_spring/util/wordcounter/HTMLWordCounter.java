package com.aiecel.wordcounter_spring.util.wordcounter;

import com.aiecel.wordcounter_spring.util.html.HTMLTextRetriever;

/**
 * Счетчик уникальных слов в HTML
 */
public class HTMLWordCounter extends WordCounterDecorator {
    private final HTMLTextRetriever textRetriever;

    public HTMLWordCounter(WordCounter wordCounter, HTMLTextRetriever textRetriever) {
        super(wordCounter);
        this.textRetriever = textRetriever;
    }

    /**
     * Подсчитывает кол-во вхождений уникальных слов в видимом тексте на HTML
     *
     * @param html html
     */
    public void countInHTML(String html) {
        String[] words = textRetriever.getText(html).split("[ ,.!?\";:\\[\\]()\\n\\r\\t]");
        for (String word : words) {
            if (isValidWord(word)) count(word);
        }
    }

    private boolean isValidWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLetter(word.charAt(i))) return true;
        }

        return false;
    }
}
