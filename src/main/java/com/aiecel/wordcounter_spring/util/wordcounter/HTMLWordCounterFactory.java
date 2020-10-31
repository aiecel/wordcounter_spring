package com.aiecel.wordcounter_spring.util.wordcounter;

import com.aiecel.wordcounter_spring.util.html.HTMLTextRetriever;

public class HTMLWordCounterFactory {
    private final HTMLTextRetriever htmlTextRetriever;

    public HTMLWordCounterFactory(HTMLTextRetriever htmlTextRetriever) {
        this.htmlTextRetriever = htmlTextRetriever;
    }

    public HTMLWordCounter getHTMLWordCounter() {
        return new HTMLWordCounter(new WordCounterImpl(), htmlTextRetriever);
    }
}
