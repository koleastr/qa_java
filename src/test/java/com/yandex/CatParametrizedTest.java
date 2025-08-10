package com.yandex;

import com.example.Cat;
import com.example.Predator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CatParametrizedTest {

    @Mock
    private Predator mockPredator;

    @ParameterizedTest
    @MethodSource("foodProvider")
    void testGetFoodWithDifferentMeals(List<String> food) throws Exception {
        Mockito.when(mockPredator.eatMeat()).thenReturn(food);
        Cat cat = new Cat(mockPredator);
        assertEquals(food, cat.getFood());
    }

    private static Stream<Arguments> foodProvider() {
        return Stream.of(
                Arguments.of(List.of("Рыба")),
                Arguments.of(List.of("Мясо", "Птица")),
                Arguments.of(List.of())
        );
    }
}