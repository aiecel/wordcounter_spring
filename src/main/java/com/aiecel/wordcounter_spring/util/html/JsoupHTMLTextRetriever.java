package com.aiecel.wordcounter_spring.util.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

/**
 * Класс для извлечения видимого текста из HTML
 */
public class JsoupHTMLTextRetriever implements HTMLTextRetriever {
    /**
     * Возвращает видимый текст из HTML
     *
     * @param html html
     * @return видимый текст
     */
    @Override
    public String getText(String html) {
        Document document = Jsoup.parse(html);

        StringBuilder textBuilder = new StringBuilder();
        Elements tags = document.select("*");
        for (Element tag : tags) {
            for (TextNode textNode : tag.textNodes()) {
                String text = textNode.text().trim();
                if (text.length() > 0) {
                    textBuilder.append(text).append(" ");
                }
            }
        }
        return textBuilder.toString();
    }
}
