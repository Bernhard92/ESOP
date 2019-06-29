package sheet6.clockexamples.countdownalarm;
import javax.swing.*;

/**
 * A clock application with a graphical user interface.
 *
 * This application displays a digital count down clock on the screen.
 * The application is started by providing six program arguments indicating
 * the time span until which the alarm should sound.
 *
 * Program arguments
 * 1) HH - time span hours (a value from 00 to 23)
 * 2) MM - time span minutes (a value from 00 to 59)
 * 3) SS - time span seconds (a value from 00 to 59)
 *
 * Normally the last three parameters are each set to 00. But other values
 * are possible. However, any value diverging from 00 will reduce the time span
 * indicated together by the three first parameters by the provided non-00 value!!!
 * 4) 00 - hour of alarm (a value from 00 to 23)
 * 5) 00 - minute of alarm (a value from 00 to 59)
 * 6) 00 - second of alarm (a value from 00 to 59)
 *
 * @author ESOP Team 2019
 *
 */

public class MainCountDownAlarmClock {

    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int s = Integer.parseInt(args[2]);


        // HERE create three ChainedCountDownCounters.
        // One for the hours, one for the minutes, and one for the seconds. 	
        ChainedCountDownCounter hoursCounter = new ChainedCountDownCounter(h,24,null);
        ChainedCountDownCounter minsCounter = new ChainedCountDownCounter(m,60,hoursCounter);
        ChainedCountDownCounter secsCounter = new ChainedCountDownCounter(s,60,minsCounter);

        // HERE the three ChainedCountDownCounters you have created above are passed
        // to the CountDownAlarmClockView! Don't change anything here!
        CountDownAlarmClockView view = new CountDownAlarmClockView(hoursCounter,
                minsCounter,
                secsCounter,
                Integer.parseInt(args[3]),
                Integer.parseInt(args[4]),
                Integer.parseInt(args[5]));

        JFrame f = new JFrame("Countdown Clock with Alarm");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(view);
        f.pack();
        f.setResizable(false);
        f.setVisible(true);
    }
}
