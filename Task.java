public class Task {
    private String name;
    private int time;
    public Task(String name, int time) {
        this.name=name;
        this.time=time;
    }
    public String getName() {
        return this.name;
    }
    public int getTime() {
        return this.time;
    }
    public void setName(String name) {
        this.name=name;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public String toString() {
        return this.name + ", " + (this.time%60==0?this.time/60+"h":this.time+"m");
    }
}
