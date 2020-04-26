public class Client implements Comparable<Client>{
    protected int idcode;
    protected String name;
    protected String surname;
    protected int age;

    public int getIdcode() {
        return idcode;
    }

    public void setIdcode(int idcode) {
        this.idcode = idcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Client() {
        this.idcode += 1;
        this.name = null;
        this.surname = null;
        this.age = 0;
    }

    public Client(int idcode, String name, String surname, int age) {
        this.idcode = idcode;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public int compareTo(Client obj) {
        return this.age-obj.age;
    }

    @Override
    public String toString() {
        return("ID: " + idcode + ", Name: " + name + ", Surname: " + surname + ", Age: " + age);
    }
}
