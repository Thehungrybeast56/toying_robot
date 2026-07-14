public class SecurityRobot extends Robot {
    public SecurityRobot() { super("Security Robot"); }
    
    @Override public void moveForward() { saveHistory("Patrolling Forward"); }
    @Override public void moveBackward() { saveHistory("Patrolling Backward"); }
    @Override public void turnLeft() { saveHistory("Turned Left"); }
    @Override public void turnRight() { saveHistory("Turned Right"); }
    @Override public void stop() { saveHistory("Stopped Patrol"); }
}