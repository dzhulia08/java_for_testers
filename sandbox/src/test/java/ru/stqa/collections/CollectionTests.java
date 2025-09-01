package ru.stqa.collections;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        var list = new ArrayList<>(List.of("a", "b", "c", "a")); // Создали список для хранения строк (имеет переменную длину)
        Assertions.assertEquals(4, list.size()); // размер списка
        Assertions.assertEquals("a", list.get(0)); // получить элемент

        list.set(0, "d"); // записать значение в элемент с указанным индексом
        Assertions.assertEquals("d", list.get(0));
    }

    @Test
    void setTests() {
//        var set = Set.of("a", "b", "c"); // создали множество (в множестве элементы не могут повторяться)
//        var set = Set.copyOf(List.of("a", "b", "c", "a"));
        var set = new HashSet<>(List.of("a", "b", "c", "a"));
        Assertions.assertEquals(3, set.size()); // размер множества
        //var element = set.stream().findAny().get();
        set.add("a");
        Assertions.assertEquals(3, set.size());

        set.add("d");
        Assertions.assertEquals(4, set.size());
    }

}
