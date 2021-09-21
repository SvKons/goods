package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Book book1 = new Book(123, "Наблюдая", 1000, "Блейк Пирс");
    private Book book2 = new Book(456, "Сильнее страха", 500, "Марк Леви");
    private Book book3 = new Book(789, "Странное путешествие мистера Долдри", 800, "Марк Леви");


    private Smartphone huawei = new Smartphone(12, "P20", 10000, "Huawei");
    private Smartphone honor = new Smartphone(34, "8X", 20000, "Huawei");
    private Smartphone redmi = new Smartphone(56, "10Pro", 15000, "Xiaomi");

    @Test
    public void shouldSaveOneItem() {
        repository.save(book2);

        Product[] expected = new Product[]{book2};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        ProductRepository repository = new ProductRepository();
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);

        repository.removeById(123);

        Product[] expected = new Product[]{book2, book3};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        repository.save(huawei);
        repository.save(honor);
        repository.save(redmi);

        Product[] expected = new Product[]{huawei, honor, redmi};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
}
