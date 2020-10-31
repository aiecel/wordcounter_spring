package com.aiecel.wordcounter_spring.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Страница
 */
@Entity
@Table(name = "pages")
public class Page {
    /**
     * Id страницы
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * URL страницы
     */
    @Column(unique = true)
    private String url;

    /**
     * Подсчитанные слова на странице
     */
    @OneToMany(mappedBy = "page", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Word> words;

    public Page() {
    }

    public Page(String url) {
        this.url = url;
        this.words = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public Page setId(long id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Page setUrl(String url) {
        this.url = url;
        return this;
    }

    public Collection<Word> getWords() {
        return words;
    }

    public void clearWords() {
        words.clear();
    }

    public void addAllWords(Collection<Word> words) {
        this.words.addAll(words);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page page = (Page) o;
        return id == page.id &&
                Objects.equals(url, page.url) &&
                Objects.equals(words, page.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, words);
    }
}
