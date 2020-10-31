package com.aiecel.wordcounter_spring.repository;

import com.aiecel.wordcounter_spring.model.Word;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий для слов
 */
@Repository
public interface WordRepository extends CrudRepository<Word, Long> {
    /**
     * Возвращает список всех слов, отсортированный по кол-ву вхождений
     */
    @Query("SELECT w FROM Word w ORDER BY w.occurrences DESC")
    List<Word> findAllOrderByOccurrencesDesc();

    /**
     * Возвращает список всех слов на странице с заданным URL, отсортированный по кол-ву вхождений
     *
     * @param url url страницы
     */
    @Query("SELECT w FROM Page p JOIN p.words w WHERE p.url = ?1 ORDER BY w.occurrences DESC")
    List<Word> findAllByUrlOrderByOccurrencesDesc(String url);
}
