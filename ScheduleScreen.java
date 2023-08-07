import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ScheduleScreen extends JPanel {
    JFrame frame = new JFrame("Schedule");

    public void addText(String text, int x, int y, int size, boolean bold) {
        JLabel label = new JLabel(text);
        label.setBounds(x,y,400,50);
        label.setFont(new Font("Trebuchet MS", bold?Font.BOLD:Font.PLAIN, size));
        frame.add(label);
    }
    public void addText(String text, int x, int y, int size) {
        addText(text,x,y,size,false);
    }

    public ScheduleScreen(List<Task> taskList) {

        ScheduleCreator scheduleCreator = new ScheduleCreator(taskList);
        List<Task> schedule = scheduleCreator.createSchedule();

        addText("Your Schedule", 200,0,24,true);

        int i=0;
        for (Task task : schedule) {
            addText(task.toString(),30,50+i*30,18);
            i++;
        }

        frame.setSize(600,200+Math.max(taskList.size()*70,600));
        frame.getContentPane().setBackground(new Color(170,230,250));
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
