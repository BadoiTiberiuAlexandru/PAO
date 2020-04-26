import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ClientDatabase {
    private int numberOfObjects;
    private int latestID;
    private String fileName;
    ArrayList<Client> Database = new ArrayList<>();

    public ClientDatabase(String fileName) {
        this.fileName = fileName;
        this.numberOfObjects = 0;
        this.latestID = 0;
        try {
            File ClientDB = new File("src/" + fileName);
            Scanner s = new Scanner(ClientDB);
            while (s.hasNextLine()) {
                String data = s.nextLine();
                String[] datasplit = data.split(",", 4);
                int id = Integer.parseInt(datasplit[0]);
                String name = datasplit[1];
                String surname = datasplit[2];
                int age = Integer.parseInt(datasplit[3]);
                Database.add(new Client(id, name, surname, age));
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

    public void addClient(String name, String surname, int age) {
        numberOfObjects += 1;
        latestID += 1;
        Database.add(new Client(latestID, name, surname, age));
        Collections.sort(Database);
        try {
            FileWriter writer = new FileWriter ("src/"+ fileName);
            for (Client n:Database) {
                writer.write(n.getIdcode() + "," + n.getName() + "," + n.getSurname() + "," + n.getAge());
                writer.write(System.lineSeparator());
            }
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Write Error");
            e.printStackTrace();
        }
    }

    public void removeClient(int removeID) {
        int i = 0;
        for (Client n:Database) {
            if (n.getIdcode() == removeID) {
                Database.remove(i);
                numberOfObjects -= 1;
            }
            i++;
        }
        try {
            FileWriter writer = new FileWriter ("src/"+ fileName);
            writer.write((String.valueOf(numberOfObjects)));
            writer.write(System.lineSeparator());
            writer.write((String.valueOf(latestID)));
            writer.write(System.lineSeparator());
            for (Client n:Database) {
                writer.write(n.getIdcode() + " " + n.getName() + " " + n.getSurname() + " " + n.getAge());
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

    public void showDatabase() {
        System.out.println("Number of Clients: " + numberOfObjects);
        for (Client n:Database) {
            System.out.println(n);
        }
    }
}
