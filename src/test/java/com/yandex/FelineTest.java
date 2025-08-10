package com.yandex;

import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FelineTest {

    @Spy
    private Feline feline;

    @Test
    void testEatMeat() throws Exception {
        Mockito.doReturn(List.of("Мясо")).when(feline).getFood("Хищник");
        assertEquals(List.of("Мясо"), feline.eatMeat());
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    void testGetKittensDefault() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    void testGetFamily() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, feline.getFamily());
    }

    @Test
    void testEatMeatThrowsException() throws Exception {
        Mockito.doThrow(new RuntimeException()).when(feline).getFood("Хищник");
        assertThrows(Exception.class, () -> feline.eatMeat());
    }
}