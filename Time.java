public class Time {
    public static final Time NULL = new Time(-1,-1);
    private int hour;
    private int minute;
    public Time(int hour, int minute) {
        this.hour=hour;
        this.minute=minute;
    }

    public String toString() {
        return
                (this.hour==0?"12":this.hour)+":"+
                        (this.minute == 0?"00":this.minute);
    }

    public Time copy() {
        return new Time(this.hour,this.minute);
    }

    public void addMinutes(int minutes) {
        this.minute += minutes;
        while (this.minute >= 60) {
            this.minute -=60;
            this.hour++;
        }
        this.hour %= 12;
    }
}
