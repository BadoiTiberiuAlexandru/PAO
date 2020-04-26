import java.text.SimpleDateFormat;
import java.util.Date;

public class Action {
    private String action;
    private String timestamp;

    public Action(String action) {
        this.action = action;
        this.timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    }

    public Action(String timestamp, String action) {
        this.action = action;
        this.timestamp = timestamp;
    }

    public void showAction() {
        System.out.println(timestamp + ',' + action);
    }

    public String getAction() {
        return action;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return(this.timestamp + "," + this.action);
    }
}
