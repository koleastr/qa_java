package com.yandex;

import com.example.Feline;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FelineParametrizedTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 100})
    void testGetKittensWithCount(int kittensCount) {
        Feline feline = new Feline();
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}