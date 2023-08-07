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

        final Time dinnerEndTime = dinnerTime.copy();
        dinnerEndTime.addMinutes(dinnerLength);

        final int allottedTime = 360-dinnerLength; // 4 - 10, without 7-8 for dinner: 5h/300m
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
        schedule.remove(schedule.size()-1); // remove last break


        List<Task> scheduleWithDinner = new ArrayList<>();
        for (Task task:schedule) {
            boolean afterDinner = task.getTime().comesAtOrAfter(dinnerTime);
            if (afterDinner) {
                task.moveForward(dinnerLength);
            } else if (task.endTime().comesAtOrAfter(dinnerTime)) {
                int initialCutoff = task.getTime().minutesUntil(dinnerTime);
                int normalDuration = task.getDuration();
                task.setDuration(initialCutoff);
                scheduleWithDinner.add(task);
                scheduleWithDinner.add(new Task("Dinner",dinnerLength,dinnerTime));
                scheduleWithDinner.add(new Task(task.getName(),normalDuration-initialCutoff,dinnerEndTime));
                continue;
            }
            scheduleWithDinner.add(task);
        }

        return scheduleWithDinner;
    }

}
