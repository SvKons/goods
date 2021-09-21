package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    public void shouldUseEquals() {
        Product first = new Product(123, "QA", 500);
        Product second = new Product(123, "QA", 500);

        assertEquals(first, second);
    }
}
