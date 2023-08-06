public class Task {
    private String name;
    private int duration;
    private Time time;
    public Task(String name, int duration, Time time) {
        this.name=name;
        this.duration=duration;
        this.time=time.copy();
    }

    public Task(String name, int duration) {
        this(name, duration, Time.NULL);
    }

    public String getName() {
        return this.name;
    }
    public Time getTime() {
        return this.time;
    }
    public void setName(String name) {
        this.name=name;
    }
    public void setTime(Time time) {
        this.time = time;
    }
    public String toString() {
        return this.name + ", " + (this.duration%60==0?this.duration/60+"h":this.duration+"m") + " ------ " + this.time.toString();
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
