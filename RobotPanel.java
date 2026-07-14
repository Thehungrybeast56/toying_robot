import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class RobotPanel extends JPanel {
    private int x = 220, y = 120;
    private Color robotColor = Color.BLUE;

    public void setRobotColor(Color c) { robotColor = c; repaint(); }
    
    public void moveForward() { 
        y = Math.max(10, y - 10); 
        repaint(); 
    }
    
    public void moveBackward() { 
        y = Math.min(getHeight() - 40, y + 10); 
        repaint(); 
    }
    
    public void moveLeft() { 
        x = Math.max(0, x - 10); 
        repaint(); 
    }
    
    public void moveRight() { 
        x = Math.min(getWidth() - 40, x + 10); 
        repaint(); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(robotColor);
        g.fillRect(x, y, 40, 40);
        g.setColor(Color.BLACK);
        g.fillOval(x + 10, y - 10, 20, 20);
    }
}