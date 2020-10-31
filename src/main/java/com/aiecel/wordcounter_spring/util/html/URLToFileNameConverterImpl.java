package com.aiecel.wordcounter_spring.util.html;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Конвертор url страницы в имя файла
 */
public class URLToFileNameConverterImpl implements URLToFileNameConverter {
    public static final String FILE_EXTENSION = "html";

    /**
     * Конвертирует url страницы в имя файла
     *
     * @param url url страницы
     * @return имя файла
     */
    @Override
    public String convert(String url) {
        String fileName;
        try {
            fileName =  new URI(url).getHost() + "_" + url.hashCode();
        } catch (URISyntaxException e) {
            fileName = String.valueOf(url.hashCode());
        }
        return fileName + "." + FILE_EXTENSION;
    }
}
