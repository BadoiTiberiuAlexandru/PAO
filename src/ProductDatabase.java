import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductDatabase {
    private int numberOfObjects;
    private int latestID;
    private String fileName;
    ArrayList<Product> Database = new ArrayList<>();

    public ProductDatabase(String fileName) {
        this.fileName = fileName;
        this.latestID = 0;
        this.numberOfObjects = 0;
        try {
            File ProductDB = new File("src/" + fileName);
            Scanner s = new Scanner(ProductDB);
            while (s.hasNextLine()) {
                String data = s.nextLine();
                String[] datasplit = data.split(",", 3);
                int id = Integer.parseInt(datasplit[0]);
                String name = datasplit[1];
                float price = Float.parseFloat(datasplit[2]);
                Database.add(new Product(id, name, price));
                if (this.latestID < id) {
                    this.latestID = id;
                }
                this.numberOfObjects += 1;
            }
            s.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File was not found");
            e.printStackTrace();
        }
    }

    public void addProduct(String name, float price) {
        this.numberOfObjects += 1;
        this.latestID += 1;
        Database.add(new Product(latestID, name, price));
        try {
            FileWriter writer = new FileWriter ("src/"+ fileName);
            for (Product n:Database) {
                writer.write(n.getCode() + "," + n.getName() +"," + n.getPrice());
                writer.write(System.lineSeparator());
            }
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Write Error");
            e.printStackTrace();
        }
    }

    public void removeProduct(int removeID) {
        int i = 0;
        for (Product n:Database) {
            if (n.getCode() == removeID) {
                Database.remove(i);
                numberOfObjects -= 1;
            }
            i++;
        }
        try {
            FileWriter writer = new FileWriter ("src/"+ fileName);
            for (Product n:Database) {
                writer.write(n.getCode() + "," + n.getName() + "," + n.getPrice());
                writer.write(System.lineSeparator());
            }
            writer.close();
            System.out.println("Wrote to file.");
        }
        catch (IOException e) {
            System.out.println("Write Error");
            e.printStackTrace();
        }
    }

    public Product returnProduct(int pid) {
        for (Product n:Database) {
            if(n.getCode()==pid) {
                return n;
            }
        }
        return null;
    }

    public void showDatabase() {
        System.out.println("Number of Products: " + numberOfObjects);
        for (Product n:Database) {
            System.out.println(n);
        }
    }
}
