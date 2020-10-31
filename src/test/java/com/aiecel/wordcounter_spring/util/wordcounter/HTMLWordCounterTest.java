package com.aiecel.wordcounter_spring.util.wordcounter;

import com.aiecel.wordcounter_spring.util.html.JsoupHTMLTextRetriever;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HTMLWordCounterTest {
    @Test
    void countInHTML() {
        HTMLWordCounter htmlWordCounter = new HTMLWordCounter(new WordCounterImpl(), new JsoupHTMLTextRetriever());

        String testHtml =
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    Body body body test\n" +
                "    <h1>Header</h1>\n" +
                "</body>\n" +
                "</html>";

        htmlWordCounter.countInHTML(testHtml);

        assertEquals(1, htmlWordCounter.getOccurrences("test"));
        assertEquals(3, htmlWordCounter.getOccurrences("body"));
        assertEquals(1, htmlWordCounter.getOccurrences("title"));
        assertEquals(1, htmlWordCounter.getOccurrences("header"));
        assertEquals(0, htmlWordCounter.getOccurrences("testtest"));
    }
}