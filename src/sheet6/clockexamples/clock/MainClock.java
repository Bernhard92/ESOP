package sheet6.clockexamples.clock;

import javax.swing.*;
/**
 * A clock application with a graphical user interface.
 *
 * This application displays a digital clock on the screen.
 * The application is started by providing three program arguments indicating
 * the initial hours, minutes and seconds.
 *
 * Program arguments
 * 1) HH - hour (a value from 00 to 23)
 * 2) MM - minute (a value from 00 to 59)
 * 3) SS - second (a value from 00 to 59)
 *
 * @author ESOP Team 2012
 *
 */

public class MainClock {
    /**
     * Expects a initial clock time (HH MM SS)
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

        ClockView view = new ClockView(hoursCounter,
                minsCounter,
                secsCounter);

        JFrame f = new JFrame("clock");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(view);
        f.pack();
        f.setResizable(false);
        f.setVisible(true);
    }
}
