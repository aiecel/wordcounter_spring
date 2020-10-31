package com.aiecel.wordcounter_spring.util.html;

import java.io.IOException;
import java.net.URL;

/**
 * Интерфейс для классов загрузки HTML
 */
public interface HTMLDownloader {
    /**
     * Возвращает HTML страницы по указанному URL
     *
     * @param url url страницы
     * @return HTML страницы с указанным url
     */
    String getHTMLFromUrl(URL url) throws IOException;
}
