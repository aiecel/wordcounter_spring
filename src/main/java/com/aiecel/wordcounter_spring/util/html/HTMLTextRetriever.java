package com.aiecel.wordcounter_spring.util.html;

/**
 * Интерфейс для классов извлечения видимого текста из HTML
 */
public interface HTMLTextRetriever {
    /**
     * Возвращает видимый текст из HTML
     *
     * @param html html
     * @return видимый текст
     */
    String getText(String html);
}
