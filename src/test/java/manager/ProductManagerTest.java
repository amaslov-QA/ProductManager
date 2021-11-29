package manager;

import org.junit.jupiter.api.Test;
import domain.Book;
import domain.Product;
import domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductManager manager = new ProductManager();


    //private Book stalker = new Book();
    private Book stalker1 = new Book(1, "stalker1", 255, "Orehov");
    private Book stalker2 = new Book(3, "stalker2", 350, "Levickiy");
    private Book it = new Book(4, "it", 1935, "King");
    private Book it2 = new Book(5, "it2", 1353, "King");

    private Smartphone sony = new Smartphone(7, "Xperia", 15150, "Sony");
    private Smartphone apple = new Smartphone(2, "11", 94025, "Apple");
    private Smartphone poco = new Smartphone(8, "F3", 30150, "Poco");
    private Product product = new Product(9, "HonorF", 14550);


    @Test
    public void shouldSaveOneBook() {


        manager.add(stalker1);

        Product[] expected = new Product[]{stalker1};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchBy() {
        String textForSearch = "Stalker";

        manager.add(stalker2);
        manager.add(it2);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAuthor() {
        String textForSearch = "King";

        manager.add(stalker2);
        manager.add(it2);

        Product[] expected = new Product[]{it2,};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchByAuthorTwo() {
        String textForSearch = "King";

        manager.add(stalker2);
        manager.add(it2);
        manager.add(it);

        Product[] expected = new Product[]{it2,it};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByName() {
        String textForSearch = "11";

        manager.add(sony);
        manager.add(it2);
        manager.add(apple);

        Product[] expected = new Product[]{apple,};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturer() {
        String textForSearch = "Sony";

        manager.add(sony);
        manager.add(it2);
        manager.add(apple);
        manager.add(poco);

        Product[] expected = new Product[]{sony,};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAuthorInBooksAndSmartphones() {
        String textForSearch = "Levickiy";

        manager.add(stalker2);
        manager.add(it2);
        manager.add(poco);

        Product[] expected = new Product[]{stalker2,};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturerWhichIsNot() {
        String textForSearch = "Honor";

        manager.add(sony);
        manager.add(it2);
        manager.add(product);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);
    }
}
