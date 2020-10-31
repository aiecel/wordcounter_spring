package com.aiecel.wordcounter_spring.util.html;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс для сохранения HTML в файл
 */
public class FileHTMLWriter implements HTMLWriter {
    private final URLToFileNameConverter converter;

    public FileHTMLWriter(URLToFileNameConverter converter) {
        this.converter = converter;
    }

    public URLToFileNameConverter getConverter() {
        return converter;
    }

    /**
     * Сохраняет HTML в файл
     *
     * @param url url HTML страницы
     * @param html html страница
     */
    @Override
    public void save(String url, String html) throws IOException {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(converter.convert(url)))) {
            fileWriter.write(html);
        }
    }
}
