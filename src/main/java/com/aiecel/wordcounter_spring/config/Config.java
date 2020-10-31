package com.aiecel.wordcounter_spring.config;

import com.aiecel.wordcounter_spring.util.html.*;
import com.aiecel.wordcounter_spring.util.wordcounter.HTMLWordCounterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация бинов Spring
 */
@Configuration
public class Config {
    @Bean
    public HTMLDownloader htmlDownloader() {
        return new HTMLDownloaderImpl();
    }

    @Bean
    public HTMLTextRetriever htmlTextRetriever() {
        return new JsoupHTMLTextRetriever();
    }

    @Bean
    public FileHTMLWriter htmlWriter() {
        return new FileHTMLWriter(new URLToFileNameConverterImpl());
    }

    @Bean
    public HTMLWordCounterFactory textWordCounterFactory() {
        return new HTMLWordCounterFactory(htmlTextRetriever());
    }
}
