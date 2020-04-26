public class RegularClient extends Client {
    protected int points;

    public RegularClient(int idcode, String name, String surname, int age, int points) {
        super(idcode, name, surname, age);
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return("ID: " + idcode + ", Name: " + name + ", Surname: " + surname + ", Age: " + age + ", Points: " + points);
    }
}
