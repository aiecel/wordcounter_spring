package com.aiecel.wordcounter_spring.util.wordcounter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterImplTest {
    private WordCounter testWordCounter;

    @BeforeEach
    void before() {
        testWordCounter = new WordCounterImpl();
    }

    @Test
    void getOccurrences() {
        assertEquals(0, testWordCounter.getOccurrences("test"));

        testWordCounter.count("test");
        assertEquals(1, testWordCounter.getOccurrences("test"));

        testWordCounter.count("test");
        testWordCounter.count("test");
        testWordCounter.count("test");
        assertEquals(4, testWordCounter.getOccurrences("test"));

        assertEquals(0, testWordCounter.getOccurrences("testtest"));
    }

    @Test
    void getAllOccurrences() {
        testWordCounter.count("test1");
        testWordCounter.count("test2");
        testWordCounter.count("test2");

        Map<String, Integer> expectedOccurrences = new HashMap<>();
        expectedOccurrences.put("test1", 1);
        expectedOccurrences.put("test2", 2);

        assertEquals(expectedOccurrences, testWordCounter.getAllOccurrences());
    }
}