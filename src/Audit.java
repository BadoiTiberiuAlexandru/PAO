import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Audit {
    private String fileName;
    ArrayList<Action> actions = new ArrayList<>();

    public Audit(String fileName) {
        this.fileName = fileName;
        int i = 0;
        try {
            File auditFile = new File("src/" + fileName);
            Scanner s = new Scanner(auditFile);
            while (s.hasNextLine()) {
                String data = s.nextLine();
                String[] datasplit = data.split(",", 2);
                String newTimestamp = datasplit[0];
                String newAction = datasplit[1];
                this.actions.add(new Action(newTimestamp, newAction));
            }
            s.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File was not found");
            e.printStackTrace();
        }
    }

    public void addAction(String action) {
        actions.add(new Action(action));
        try {
            FileWriter writer = new FileWriter ("src/"+ fileName);
            for (Action n:actions) {
                writer.write(n.getTimestamp() + "," + n.getAction());
                writer.write(System.lineSeparator());
            }
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Write Error");
            e.printStackTrace();
        }
    }

    public void showAudit() {
        for (Action n:actions) {
            System.out.println(n);
        }
    }
}
