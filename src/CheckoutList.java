import java.util.ArrayList;

public class CheckoutList {
    int numberOfItems;
    float TotalPrice;
    ArrayList<Product> List = new ArrayList<>();

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public float getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        TotalPrice = totalPrice;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public CheckoutList() {
        numberOfItems = 0;
        TotalPrice = 0;
    }

    public void addProduct(Product P) {
        numberOfItems += 1;
        List.add(P);
        TotalPrice += P.getPrice();
    }

    public void removeProduct(int pid) {
        int i = 0;
        boolean removed = false;
        for (Product n:List) {
            if (n.getCode() == pid) {
                TotalPrice -= n.getPrice();
                List.remove(i);
                numberOfItems -= 1;
                removed = true;
                break;
            }
            i++;
        }
        if (removed == false) System.out.println("No product with the id " + pid + " was found, no product was removed.");
    }

    public void inputDiscount(int d) {
        this.numberOfItems += 1;
        Product Discount = new Product(d*(-1), "Discount",  d);
        List.add(Discount);
        TotalPrice = TotalPrice - ((TotalPrice*d)/100);
    }

    public void showList() {
        System.out.println("Number of Products: " + numberOfItems);
        for (Product n:List) {
            System.out.println(n);
        }
    }
}
