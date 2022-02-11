package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    Product smartphone = new Smartphone(1, "Xperia", 1000, "Sony");
    Product book = new Book(2, "Remark", 100, "Sony");
    ProductManager productManager = new ProductManager(repo);

    @BeforeEach
    public void setUp() {
        productManager.add(smartphone);
        productManager.add(book);
    }

    @Test
    public void shouldDeleteExistId() {
        repo.removeById(2);
        Product[] actual = repo.findAll();
        Product[] expected = new Product[] {smartphone};

        assertArrayEquals(expected,actual);

    }

    @Test
    public void shouldNotDeleteNotExistId() {

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(3);
        });
    }
}