public class Product {
    private String name;
    private int price;
    private String description;

    public Product(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
        this.description = "no description";
    }

    public Product(String name) {
        this.name = name;
        this.price = 0;
        this.description = "no description";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("\n%1$3s %2$-8s | %3$-6s %4$-12s", ">>", name, price, description);
    }
}