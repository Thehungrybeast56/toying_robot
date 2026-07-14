public class CleaningRobot extends Robot {
    public CleaningRobot() { super("Cleaning Robot"); }
    
    @Override public void moveForward() { saveHistory("Moved Forward"); }
    @Override public void moveBackward() { saveHistory("Moved Backward"); }
    @Override public void turnLeft() { saveHistory("Turned Left"); }
    @Override public void turnRight() { saveHistory("Turned Right"); }
    @Override public void stop() { saveHistory("Stopped"); }
}