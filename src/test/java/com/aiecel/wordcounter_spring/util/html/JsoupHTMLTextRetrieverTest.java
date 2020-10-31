package com.aiecel.wordcounter_spring.util.html;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsoupHTMLTextRetrieverTest {

    @Test
    void getText() {
        HTMLTextRetriever textRetriever = new JsoupHTMLTextRetriever();

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

        assertEquals("Title Body body body test Header ", textRetriever.getText(testHtml));
    }
}