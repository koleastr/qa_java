package com.yandex;

import com.example.Cat;
import com.example.Predator;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    private Predator mockPredator;

    @Test
    void testGetFood() throws Exception {
        Mockito.when(mockPredator.eatMeat()).thenReturn(List.of("Рыба"));
        Cat cat = new Cat(mockPredator);
        assertEquals(List.of("Рыба"), cat.getFood());
        Mockito.verify(mockPredator).eatMeat();
    }

    @Test
    void testGetSound() {
        Cat cat = new Cat(mockPredator);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void testGetFoodThrowsException() throws Exception {
        Mockito.when(mockPredator.eatMeat()).thenThrow(new RuntimeException());
        Cat cat = new Cat(mockPredator);
        assertThrows(Exception.class, cat::getFood);
    }
}
