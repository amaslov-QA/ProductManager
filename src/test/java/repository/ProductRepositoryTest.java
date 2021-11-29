package repository;

import org.junit.jupiter.api.Test;
import domain.Book;
import domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book stalker = new Book();
    private Book stalker2 = new Book(1, "Stalker", 350, "Levickiy");
    private Book stalkerVolume = new Book(2, "Stalker Volume", 1735, "Orehov");

    @Test
    public void shouldSaveOneBook() {
        repository.save(stalker);

        Product[] expected = new Product[]{stalker};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOneBookWithParameters() {
        repository.save(stalker2);

        Product[] expected = new Product[]{stalker2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveTwoBooksWithParameters() {
        repository.save(stalker2);
        repository.save(stalkerVolume);

        Product[] expected = new Product[]{stalker2, stalkerVolume};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldRemoveById() {
        int idToRemove = 2;


        repository.save(stalker2);
        repository.save(stalkerVolume);


        repository.removeById(idToRemove);

        Product[] expected = new Product[]{stalker2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


}
