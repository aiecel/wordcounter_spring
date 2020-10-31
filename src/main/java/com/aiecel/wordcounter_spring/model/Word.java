package com.aiecel.wordcounter_spring.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Слово на странице
 */
@Entity
@Table(name = "words")
public class Word {

    /**
     * ID слова
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Страница, на которой находится слово
     */
    @ManyToOne
    @JoinColumn(name = "page_id")
    private Page page;

    /**
     * Слово
     */
    private String word;

    /**
     * Кол-во вхождений слова на странице
     */
    private int occurrences;

    public Word() {
    }

    public Word(String word, int occurrences) {
        this.word = word;
        this.occurrences = occurrences;
    }

    public long getId() {
        return id;
    }

    public Word setId(long id) {
        this.id = id;
        return this;
    }

    public Page getPage() {
        return page;
    }

    public Word setPage(Page page) {
        this.page = page;
        return this;
    }

    public String getWord() {
        return word;
    }

    public Word setWord(String word) {
        this.word = word;
        return this;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public Word setOccurrences(int occurrences) {
        this.occurrences = occurrences;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return occurrences == word1.occurrences &&
                Objects.equals(page, word1.page) &&
                Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, word, occurrences);
    }
}
