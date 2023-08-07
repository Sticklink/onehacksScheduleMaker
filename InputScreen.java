import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class InputScreen {
    JFrame frame;
    public List<Task> taskList;
    JTextField[] activityFields;
    JTextField[] timeFields;

    JLabel errorMessage;

    public void setVisiblity (boolean visible) {
        frame.setVisible(visible);
    }

    public InputScreen(){
        frame = new JFrame("Tasks");
        frame.getContentPane().setBackground(new Color(170,230,250));

        errorMessage = new JLabel("");
        errorMessage.setBounds(200, 450, 200, 25 );
        frame.add(errorMessage);

        JLabel taskLabel = new JLabel("Task Name");
        taskLabel.setBounds(50,50,200,50);
        JLabel durLabel = new JLabel("Duration (min)");
        durLabel.setBounds(400,50,200,50);
        frame.add(taskLabel);
        frame.add(durLabel);

        // create help
        // create input fields
        activityFields = new JTextField[8];
        timeFields = new JTextField[8];
        taskList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            JTextField activity = new JTextField();
            activity.setBounds(50, 100 + 30 * i, 300, 25);
            frame.add(activity);
            activityFields[i] = activity;
        }
        for (int i = 0; i < 8; i++) {
            JTextField activity = new JTextField();
            activity.setBounds(400, 100 + 30 * i, 100, 25);
            frame.add(activity);
            timeFields[i] = activity;
        }



        // create submit button

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(250, 400, 100, 30);
        submitButton.addActionListener(
                e -> {
                    try {
                        taskList.clear();
                        for (int i = 0; i < 8; i++) {
                            String activity = activityFields[i].getText();
                            int time;
                            try {
                                time = parseInt(timeFields[i].getText());
                            } catch (Exception ex) {
                                time = 30;
                            }
                            if (activity.length() > 0) taskList.add(new Task(activity, time));
                        }
                        setVisiblity(false);
                        new ScheduleScreen(taskList, this);
                        errorMessage.setText("");
                    } catch (Exception ex) {
                        setVisiblity(true);
                        errorMessage.setText(ex.toString());
                    }
                }
        );
        frame.add(submitButton);


        frame.setSize(600,600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
