package com.yandex;

import com.example.Lion;
import com.example.Predator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class LionParametrizedTest {

    @Mock
    private Predator mockPredator;

    @ParameterizedTest
    @ValueSource(strings = {"Неизвестно", "Test", "123"})
    @NullAndEmptySource
    void testInvalidSexThrowsException(String invalidSex) {
        assertThrows(Exception.class, () -> new Lion(invalidSex, mockPredator));
    }
}