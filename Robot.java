import java.io.FileWriter;
import java.io.IOException;

public abstract class Robot implements RobotActions {
    protected String name;
    protected final String historyFile = "robot_history.txt";

    public Robot(String name) { this.name = name; }

    protected void saveHistory(String action) {
        try (FileWriter fw = new FileWriter(historyFile, true)) {
            fw.write(name + " : " + action + "\n");
        } catch (IOException ignored) {}
    }
}