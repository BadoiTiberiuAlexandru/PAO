public class Product{
    protected int code;
    protected String name;
    protected float price;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Product() {
        this.code += 1;
        this.name = null;
        this.price = 0;
    }

    public Product(int code, String name, float price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return("ID: " + this.code + ", Name: " + this.name + ", Price: " + this.price + " RON");
    }
}
