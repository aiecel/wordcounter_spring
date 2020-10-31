package com.aiecel.wordcounter_spring.util.html;

import java.io.IOException;

/**
 * Интерфейс для классов сохранения HTML
 */
public interface HTMLWriter {
    /**
     * Сохраняет HTML
     *
     * @param url url HTML страницы
     * @param html html страница
     */
    void save(String url, String html) throws IOException;
}
