public class Product {

    private final int id;
    private String name;
    private int quantity;
    private double price;

    public Product(int id,
               String name,
               int quantity,
               double price) {

    if (quantity < 0) {
        throw new IllegalArgumentException(
                "Quantity cannot be negative.");
    }

    if (price < 0) {
        throw new IllegalArgumentException(
                "Price cannot be negative.");
    }

    if (name.trim().isEmpty()) {
        throw new IllegalArgumentException(
                "Product name cannot be empty.");
    }

    this.id = id;
    this.name = name;
    this.quantity = quantity;
    this.price = price;
}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {

    if (quantity < 0) {
        throw new IllegalArgumentException(
                "Quantity cannot be negative.");
    }

    this.quantity = quantity;
}

   public void setPrice(double price) {

    if (price < 0) {
        throw new IllegalArgumentException(
                "Price cannot be negative.");
    }

    this.price = price;
}
}