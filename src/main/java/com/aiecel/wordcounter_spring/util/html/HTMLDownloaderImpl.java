package com.aiecel.wordcounter_spring.util.html;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Класс для загрузки HTML
 */
public class HTMLDownloaderImpl implements HTMLDownloader {
    /**
     * Возвращает HTML страницы по указанному URL
     *
     * @param url url страницы
     * @return HTML страницы с указанным url
     */
    @Override
    public String getHTMLFromUrl(URL url) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
            StringBuilder htmlBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                htmlBuilder.append(line).append("\n");
            }
            return htmlBuilder.toString();
        }
    }
}
