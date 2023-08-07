public class Time {
    public static final Time NULL = new Time(-1,-1);
    private int hour;
    private int minute;
    private boolean am;
    public Time(int hour, int minute) {
        this.hour=hour;
        this.minute=minute;
        this.am = false;
    }

    public String toString() {
        return
                (this.hour==0?"12":this.hour)+":"+
                        (this.minute < 10?"0":"") + this.minute + (this.am?" a.m.":" p.m.");
    }

    public Time copy() {
        return new Time(this.hour,this.minute);
    }

    public boolean comesAtOrAfter(Time time) {
        if (this.am != time.am) return this.am;
        if (this.hour != time.hour) return this.hour>time.hour;
        return this.minute >= time.minute;
    }

    public int minutesUntil(Time t) {
        return (t.hour-this.hour)*60+t.minute-this.minute;
    }

    public void addMinutes(int minutes) {
        this.minute += minutes;
        while (this.minute >= 60) {
            this.minute -=60;
            this.hour++;
        }
        while (this.hour>=12) {
            this.hour-=12;
            this.am=!this.am;
        }
    }
}
