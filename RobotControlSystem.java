import javax.swing.*;
import java.awt.*;
import java.io.*;

public class RobotControlSystem extends JFrame {
    private Robot robot = new CleaningRobot();
    private RobotPanel panel = new RobotPanel();
    
    private Timer movementTimer;
    private String currentDirection = "NONE";

    public RobotControlSystem() {
        setTitle("Robot Control");
        setSize(700, 400); 
        
        JComboBox<String> selector = new JComboBox<>(new String[]{"Cleaning Robot", "Security Robot"});
        selector.addActionListener(e -> {
            boolean isCleaning = selector.getSelectedIndex() == 0;
            robot = isCleaning ? new CleaningRobot() : new SecurityRobot();
            panel.setRobotColor(isCleaning ? Color.BLUE : Color.RED);
        });

        JPanel top = new JPanel();
        top.add(new JLabel("Select Robot:"));
        top.add(selector);
        add(top, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        JPanel controls = new JPanel();
        JButton fwd = new JButton("Forward"), bck = new JButton("Backward"), 
                lft = new JButton("Left"), rgt = new JButton("Right"), 
                stp = new JButton("Stop"), hist = new JButton("History");

        movementTimer = new Timer(100, e -> {
            switch(currentDirection) {
                case "FORWARD": panel.moveForward(); break;
                case "BACKWARD": panel.moveBackward(); break;
                case "LEFT": panel.moveLeft(); break;
                case "RIGHT": panel.moveRight(); break;
            }
        });

        fwd.addActionListener(e -> { robot.moveForward(); currentDirection = "FORWARD"; movementTimer.start(); });
        bck.addActionListener(e -> { robot.moveBackward(); currentDirection = "BACKWARD"; movementTimer.start(); });
        lft.addActionListener(e -> { robot.turnLeft(); currentDirection = "LEFT"; movementTimer.start(); });
        rgt.addActionListener(e -> { robot.turnRight(); currentDirection = "RIGHT"; movementTimer.start(); });
        stp.addActionListener(e -> { robot.stop(); currentDirection = "NONE"; movementTimer.stop(); });
        hist.addActionListener(e -> showHistory());

        for (JButton b : new JButton[]{fwd, bck, lft, rgt, stp, hist}) controls.add(b);
        add(controls, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showHistory() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("robot_history.txt"))) {
            String line;
            while ((line = br.readLine()) != null) sb.append(line).append("\n");
            JOptionPane.showMessageDialog(this, sb.toString(), "Movement History", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No history available.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RobotControlSystem::new);
    }
}