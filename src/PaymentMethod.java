public class PaymentMethod {
    private int numberOfCashPayments;
    private int numberOfCardPayments;
    private float valueOfCashPayments;
    private float valueOfCardPayments;

    public int getNumberOfCashPayments() {
        return numberOfCashPayments;
    }

    public void setNumberOfCashPayments(int numberOfCashPayments) {
        this.numberOfCashPayments = numberOfCashPayments;
    }

    public int getNumberOfCardPayments() {
        return numberOfCardPayments;
    }

    public void setNumberOfCardPayments(int numberOfCardPayments) {
        this.numberOfCardPayments = numberOfCardPayments;
    }

    public float getValueOfCashPayments() {
        return valueOfCashPayments;
    }

    public void setValueOfCashPayments(float valueOfCashPayments) {
        this.valueOfCashPayments = valueOfCashPayments;
    }

    public float getValueOfCardPayments() {
        return valueOfCardPayments;
    }

    public void setValueOfCardPayments(float valueOfCardPayments) {
        this.valueOfCardPayments = valueOfCardPayments;
    }

    public PaymentMethod() {
       this.numberOfCashPayments = 0;
       this.numberOfCardPayments = 0;
       this.valueOfCashPayments = 0;
       this.valueOfCardPayments = 0;
    }

    public void addCash(float cash) {
        this.valueOfCashPayments += cash;
        this.numberOfCashPayments += 1;
    }

    public void addCard(float cash) {
        this.valueOfCardPayments += cash;
        this.numberOfCardPayments += 1;
    }
}
