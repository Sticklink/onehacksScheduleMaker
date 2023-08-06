import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class InputScreen {
    JFrame window;
    List<Task> data;
    JTextField[] activityFields;
    JTextField[] timeFields;

    InputScreen(){
        window = new JFrame("Tasks");
        // create help
        // create input fields
        activityFields = new JTextField[8];
        timeFields = new JTextField[8];
        data = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            JTextField activity = new JTextField();
            activity.setBounds(50, 100 + 30 * i, 300, 25);
            window.add(activity);
            activityFields[i] = activity;
        }
        for (int i = 0; i < 8; i++) {
            JTextField activity = new JTextField();
            activity.setBounds(400, 100 + 30 * i, 100, 25);
            window.add(activity);
            timeFields[i] = activity;
        }

        // create submit button

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(250, 400, 100, 30);
        submitButton.addActionListener(
                e -> {
                    for (int i = 0; i < 8; i++) {
                        String activity = activityFields[i].getText();
                        int time;
                        try {time = parseInt(timeFields[i].getText());} catch (Exception ex) {time = 0;}
                        data.add(new Task(activity, time));
                    }
                }
        );
        window.add(submitButton);


        window.setSize(600,600);
        window.setLayout(null);
        window.setVisible(true);
    }



    public static void main(String[] args) {
        new InputScreen();
    }
}
