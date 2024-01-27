class Time {
    int hour;
    int minutes;
    int seconds;
    static int count;

    Time() {
        hour = 0;
        minutes = 0;
        seconds = 0;
        count++;
    }

    Time(int hour, int minutes, int seconds) {
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
        count++;
    }

    Time(Time t) {
        this.hour = t.hour;
        this.minutes = t.minutes;
        this.seconds = t.seconds;
        count++;
    }

    public void secondsToTime(int time) {
        float hr = (float) ((double) time / 60) / 60;
        this.hour = (int) hr;
        float min = ((float) time / 60) - hour * 60;
        this.minutes = (int) min;
        this.seconds = time - ((hour * 60 * 60) + (minutes * 60));
    }

    public void hoursToTime(float time) {
        int ti = (int) (time * 60 * 60);
        secondsToTime(ti);
    }

    public void minutesToTime(float time) {
        int ti = (int) (time * 60);
        secondsToTime(ti);
    }

    public void display() {
        System.out.println("Hour= " + hour);
        System.out.println("Minutes= " + minutes);
        System.out.println("Seconds= " + seconds);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) throws Exception {
        if (seconds >= 0) {
            this.seconds = seconds;
        } else {
            throw new Exception("InvalidValueException");
        }
    }

    public static int getCount() {
        return count;
    }

    public void addSecondsToTime(int seconds){
        this.seconds += seconds;
    }
}

public class Lab2 {
    public static void main(String[] args) {
        Time t1 = new Time();
        t1.setHour(15);
        t1.setMinutes(5);
        t1.display();
        System.out.println("");
        // demonstrating parameterized constructor
        Time t2 = new Time(15, 5, 7);
        t2.display();
        System.out.println("");
        // demonstrating copy constructor
        Time t3 = new Time(t1);
        t3.addSecondsToTime(53);
        t3.display();
        System.out.println("");
        // generating exception
        try {
            t3.setSeconds(-5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally called");
        }
        System.out.println("");
        Time t4 = new Time();
        t4.hoursToTime(5.87f);
        t4.display();
        System.out.println("");
        Time t5 = new Time();
        t5.minutesToTime(100.5f);
        t5.display();
        System.out.println("");
        Time t6 = new Time();
        t6.secondsToTime(500);
        t6.display();
        System.out.println("");
        System.out.println("Total number of Time object created: " + Time.getCount());
    }
}
