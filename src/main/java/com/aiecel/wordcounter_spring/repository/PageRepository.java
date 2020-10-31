package com.aiecel.wordcounter_spring.repository;

import com.aiecel.wordcounter_spring.model.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Репозиторий для страниц
 */
@Repository
public interface PageRepository extends CrudRepository<Page, Long> {
    /**
     * Находит страницу в базе по её URL
     *
     * @param url url страницы
     */
    Optional<Page> findByUrl(String url);
}
