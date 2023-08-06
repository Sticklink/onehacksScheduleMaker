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
        Time taskTime = startTime;
        for (Task task : taskList) {
            schedule.add(new Task(task.getName(),task.getDuration(), taskTime.copy()));
            taskTime.addMinutes(task.getDuration());
            schedule.add(new Task("Break", task.getDuration()/2,taskTime.copy()));
            taskTime.addMinutes(task.getDuration()/2);

        }
        return schedule;
    }

}
