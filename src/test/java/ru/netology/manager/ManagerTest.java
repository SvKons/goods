package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Book book1 = new Book(123, "Наблюдая", 1000, "Блейк Пирс");
    private Book book2 = new Book(456, "Сильнее страха", 500, "Марк Леви");
    private Book book3 = new Book(789, "Странное путешествие мистера Долдри", 800, "Марк Леви");


    private Smartphone huawei = new Smartphone(12, "P20", 10000, "Huawei");
    private Smartphone honor = new Smartphone(34, "8X", 20000, "Huawei");
    private Smartphone redmi = new Smartphone(56, "10Pro", 15000, "Xiaomi");

    @Test
    public void shouldSearchByManufacturer () {
        repository.save(redmi);

        Product[] expected = new Product[]{redmi};
        Product[] actual = manager.searchBy("Xiaomi");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphone() {
        repository.save(huawei);

        Product[] expected = new Product[]{huawei};
        Product[] actual = manager.searchBy("P20");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByName() {
        repository.save(honor);

        Product[] expected = new Product[]{honor};
        Product[] actual = manager.searchBy("8X");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {
        repository.save(book2);
        repository.save(book3);

        Product[] expected = new Product[]{book2, book3};
        Product[] actual = manager.searchBy("Марк Леви");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookName() {
        repository.save(book1);

        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searchBy("Наблюдая");

        assertArrayEquals(expected, actual);
    }

}
