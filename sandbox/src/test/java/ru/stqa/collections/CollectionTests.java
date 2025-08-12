package ru.stqa.collections;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionTests {

    @Test
    void arrayTests() {
        var array = new String[]{"a", "b", "c"}; // Массив имеет фиксированную длину и его элементы можно только изменять
        Assertions.assertEquals(3, array.length);
        array[0] = "a";
        Assertions.assertEquals("a", array[0]);

        array[0] = "d";
        Assertions.assertEquals("d", array[0]);
    }

    @Test
    void listTests() {
        var list = new ArrayList<>(List.of("a", "b", "c")); // Создали список для хранения строк (имеет переменную длину)
        Assertions.assertEquals(3, list.size()); // размер списка
        Assertions.assertEquals("a", list.get(0)); // получить элемент

        list.set(0, "d"); // записать значение в элемент с указанным индексом
        Assertions.assertEquals("d", list.get(0));


    }

}
