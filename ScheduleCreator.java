import java.util.ArrayList;
import java.util.List;

public class ScheduleCreator {
    List<Task> taskList;
    public ScheduleCreator(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<Task> createSchedule() {
        List<Task> schedule = new ArrayList<>();
        final Time startTime = new Time(4,0);
        final Time dinnerTime = new Time(7,0);
        final int dinnerLength = 60;
        final int allottedTime = 300; // 4 - 10, without 7-8 for dinner: 5h/300m
        int totalTaskDuration = 0;
        for (Task task:taskList) {
            totalTaskDuration += task.getDuration();
        }
        double breakAmt = Math.max(0, (double)allottedTime/totalTaskDuration - 1);


        Time taskTime = startTime.copy();
        for (Task task : taskList) {
            schedule.add(new Task(task.getName(),task.getDuration(), taskTime.copy()));
            taskTime.addMinutes(task.getDuration());
            int breakLength = (int)(task.getDuration()*breakAmt);
            schedule.add(new Task("Break", breakLength,taskTime.copy()));
            taskTime.addMinutes(breakLength);
        }
        for (Task task:schedule) {
            if (task.getTime().comesAtOrAfter(dinnerTime)) {
                task.moveForward(dinnerLength);
                System.out.println(3);
            }
        }
        return schedule;
    }

}
