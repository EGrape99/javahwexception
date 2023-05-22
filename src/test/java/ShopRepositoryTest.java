import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveId() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Product1", 100);
        Product product2 = new Product(2, "Product 2", 250);
        Product product3 = new Product(3, "Product 3", 300);
        Product product4 = new Product(4, "Product 4", 500);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.remove(3);

        Product[] expected = {product1, product2, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFoundException() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Product1", 100);
        Product product2 = new Product(2, "Product 2", 250);
        Product product3 = new Product(3, "Product 3", 300);
        Product product4 = new Product(4, "Product 4", 500);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(9));
    }

    @Test
    public void shouldSave() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Product1", 100);
        Product product2 = new Product(2, "Product 2", 250);
        Product product3 = new Product(3, "Product 3", 300);
        Product product4 = new Product(4, "Product 4", 500);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveAlreadyExistsException() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Product1", 100);
        Product product2 = new Product(2, "Product 2", 250);
        Product product3 = new Product(3, "Product 3", 300);
        Product product4 = new Product(4, "Product 4", 500);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(AlreadyExistsException.class, () -> repo.save(product4));
    }
}
