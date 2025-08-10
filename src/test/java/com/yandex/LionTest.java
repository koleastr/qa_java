package com.yandex;

import com.example.Lion;
import com.example.Predator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Predator mockPredator;

    @Test
    void testGetKittens() {
        Mockito.when(mockPredator.getKittens()).thenReturn(5);
        Lion lion = new Lion(mockPredator);
        assertEquals(5, lion.getKittens());
        Mockito.verify(mockPredator).getKittens();
    }

    @Test
    void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Птица");
        Mockito.when(mockPredator.eatMeat()).thenReturn(expectedFood);

        Lion lion = new Lion(mockPredator);
        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
        Mockito.verify(mockPredator).eatMeat();
    }

    @Test
    void testGetFoodThrowsException() throws Exception {
        Mockito.when(mockPredator.eatMeat()).thenThrow(new Exception("Ошибка"));
        Lion lion = new Lion(mockPredator);

        assertThrows(Exception.class, lion::getFood);
        Mockito.verify(mockPredator).eatMeat();
    }

    @Test
    void testDoesHaveManeForMale() throws Exception {
        Lion lion = new Lion("Самец", mockPredator);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void testDoesHaveManeForFemale() throws Exception {
        Lion lion = new Lion("Самка", mockPredator);
        assertFalse(lion.doesHaveMane());
    }
}