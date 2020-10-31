package com.aiecel.wordcounter_spring.util.html;

/**
 * Интерфейс для классов, конвертирующих url страницы в имя файла
 */
public interface URLToFileNameConverter {
    /**
     * Конвертирует url страницы в имя файла
     *
     * @param url url страницы
     * @return имя файла
     */
    String convert(String url);
}
