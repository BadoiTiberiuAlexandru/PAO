public class ProductKg extends Product {
    float weight;

    public ProductKg(int code, String name, float price) {
        super(code, name, price);
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getFinalPrice() {
        return weight * price;
    }
}
