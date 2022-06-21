package ru.netology.domain;

import domain.Books;
import domain.Product;
import domain.Smartphone;
import manager.ProductManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

public class ProductManagerTest {

    Product books1 = new Books(4322, "Каменный мост", 1800, "Александр Терехов");
    Product books2 = new Books(894, "Крепость", 2500, "Пётр Алешковский");
    Product smartphone1 = new Smartphone(397, "iPhone 13", 180_000, "Apple");
    Product smartphone2 = new Smartphone(295, "iPhone 11", 50_000, "Apple");


    @Test
    public void shouldSearchBy() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(books1);
        manager.add(books2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        manager.findAll();


        Product[] actual = manager.searchBy("К");
        Product[] expected = {books1, books2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBy1() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(books1);
        manager.add(books2);
        manager.add(smartphone1);
        manager.add(smartphone2);


        Product[] actual = manager.searchBy("13");
        Product[] expected = {smartphone1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchBy2() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(books1);
        manager.add(books2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        manager.findAll();


        Product[] actual = manager.searchBy("Ok");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(books1);
        manager.add(books2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        manager.removeById(295);
        manager.findAll();

        Product[] actual = manager.findAll();
        Product[] expected = {books1, books2, smartphone1};

        Assertions.assertArrayEquals(expected, actual);
    }


}