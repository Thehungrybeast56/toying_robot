# Robot Control System (Java Swing)

A simple, interactive Java Swing application that demonstrates core Object-Oriented Programming (OOP) principles. It allows users to select and control different types of robots on a 2D canvas.

## 🚀 Features

*   **Multiple Robot Types:** Choose between a Cleaning Robot (Blue) and a Security Robot (Red).
*   **Continuous Movement:** Click a direction (Forward, Backward, Left, Right) and the robot will move continuously until you click **Stop**.
*   **Boundary Detection:** The robot automatically detects the edges of the screen and stops moving to prevent driving out of bounds.
*   **Action Logging:** Every movement is recorded and saved locally to a file (`robot_history.txt`).
*   **History Viewer:** View the robot's movement history directly from the GUI.
*   **Clean OOP Architecture:** Built using Interfaces, Abstract Classes, and Polymorphism across multiple files.

## 📂 File Structure

The project has been modularized into six clean files for better separation of concerns:

1.  `RobotActions.java`: Interface defining core movement behaviors.
2.  `Robot.java`: Abstract base class handling history logging via file I/O.
3.  `CleaningRobot.java`: Concrete implementation for the cleaning robot.
4.  `SecurityRobot.java`: Concrete implementation for the security robot.
5.  `RobotPanel.java`: Custom JPanel managing the canvas, rendering, and boundary logic.
6.  `RobotControlSystem.java`: The main JFrame containing the GUI setup, Timer loop, and event listeners.

## 🛠️ Prerequisites

*   Java Development Kit (JDK) 8 or higher installed on your machine.
*   An IDE (like VS Code, IntelliJ IDEA, or Eclipse) or terminal.

## 💻 How to Run (Terminal/Command Prompt)

1. Open your terminal and navigate to the folder containing the project files.
2. Compile all the Java files:
   ```bash
   javac *.java
