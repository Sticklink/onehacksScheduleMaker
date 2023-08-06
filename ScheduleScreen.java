import javax.swing.*;
import java.awt.Font;

public class ScheduleScreen extends JPanel {
    JFrame frame = new JFrame("Schedule");



    public ScheduleScreen() {
        JLabel title = new JLabel("Your Schedule");
        title.setBounds(200,0,200,60);
        title.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
        frame.add(title);
        frame.setSize(600,600);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ScheduleScreen();
    }
}