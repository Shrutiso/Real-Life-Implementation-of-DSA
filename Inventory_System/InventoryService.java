import java.util.HashMap;

public class InventoryService {

    private HashMap<Integer, Product> inventory =
            new HashMap<>();

    public void addProduct(Product p) {

    if (inventory.containsKey(p.getId())) {
        throw new IllegalArgumentException(
                "Product ID already exists.");
    }

    inventory.put(p.getId(), p);
}

    public Product searchProduct(int id) {
        return inventory.get(id);
    }

    public void updateProduct(int id,
                              int quantity,
                              double price) {

        Product p = inventory.get(id);

        if (p != null) {
            p.setQuantity(quantity);
            p.setPrice(price);
        }
    }

    public void deleteProduct(int id) {
        inventory.remove(id);
    }

    public HashMap<Integer, Product> getInventory() {
        return inventory;
    }
}

