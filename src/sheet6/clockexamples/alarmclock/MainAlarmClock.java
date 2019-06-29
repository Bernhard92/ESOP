package sheet6.clockexamples.alarmclock;
import javax.swing.JFrame;

import sheet6.clockexamples.clock.ChainedCounter;

/**
 * An alarm clock application with a graphical user interface.
 *
 * This application displays a digital clock on the screen. An alarm tone sounds for 10 seconds
 * at the specified alarm time.
 *
 * The application is started by providing six program arguments indicating
 * the initial hours, minutes and seconds.
 *
 * Program arguments
 * 1) HH - hour (a value from 00 to 23)
 * 2) MM - minute (a value from 00 to 59)
 * 3) SS - second (a value from 00 to 59)
 * 4) HH - hour of alarm (a value from 00 to 23)
 * 5) MM - minute of alarm (a value from 00 to 59)
 * 6) SS - second of alarm (a value from 00 to 59)
 *
 * @author ESOP Team 2019
 *
 */
public class MainAlarmClock {
    /**
     * Expects a initial clock time (HH MM SS) and an alarm time (HH MM SS)
     *
     * @param args
     */
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int s = Integer.parseInt(args[2]);

        ChainedCounter hoursCounter = new ChainedCounter(h,24,null);
        ChainedCounter minsCounter = new ChainedCounter(m,60,hoursCounter);
        ChainedCounter secsCounter = new ChainedCounter(s,60,minsCounter);

        // Initialize a AlarmClockView with the name view here!
        AlarmClockView view = new AlarmClockView(hoursCounter,
                minsCounter,
                secsCounter,
                Integer.parseInt(args[3]),
                Integer.parseInt(args[4]),
                Integer.parseInt(args[5]));

        JFrame f = new JFrame("Alarm Clock");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(view);
        f.pack();
        f.setResizable(false);
        f.setVisible(true);
    }
}
