public class Time {
    public static final Time NULL = new Time(-1,-1);
    private int hour;
    private int minute;
    public Time(int hour, int minute) {
        this.hour=hour;
        this.minute=minute;
    }

    public String toString() {
        return this.hour+":"+this.minute;
    }

    public void addMinutes(int minutes) {
        this.minute += minutes;
        this.hour += minutes/60;
        this.minute %= 60;
        this.hour %= 12;
    }
}
