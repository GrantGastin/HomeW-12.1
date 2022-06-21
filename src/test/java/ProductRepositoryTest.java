package ru.netology.domain;

import domain.Books;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.Test;
import repository.NotFoundException;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductRepositoryTest {
    Product books1 = new Books(4322, "Каменный мост", 1800, "Александр Терехов");
    Product books2 = new Books(894, "Крепость", 2500, "Пётр Алешковский");
    Product smartphone1 = new Smartphone(397, "iPhone 13", 180_000, "Apple");
    Product smartphone2 = new Smartphone(295, "iPhone 11", 50_000, "Apple");

    @Test
    public void removeById() {
        ProductRepository repository = new ProductRepository();
        repository.save(books1);
        repository.save(books2);
        repository.save(smartphone1);
        repository.save(smartphone2);

        repository.findById(397);
        repository.removeById(397);
        repository.findAll();

        Product[] actual = repository.findAll();
        Product[] expected = {books1, books2, smartphone2};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void findById() {
        ProductRepository repository = new ProductRepository();
        repository.save(books1);
        repository.save(books2);
        repository.save(smartphone1);
        repository.save(smartphone2);


        assertThrows(NotFoundException.class, () -> {
            repository.removeById(1);

        });
    }
}