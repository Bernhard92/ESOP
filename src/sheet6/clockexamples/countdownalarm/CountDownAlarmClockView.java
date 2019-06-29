package sheet6.clockexamples.countdownalarm;

import javax.swing.JPanel;

import sheet6.clockexamples.alarmclock.AlarmClockView;
import sheet6.clockexamples.clock.ChainedCounter;



/**
 * A part of the graphical user interface used by the {@link MainCountDownAlarmClock} application.
 *
 * Extends {@link JPanel}, hosts and manages three {@link ChainedCounter} objects.
 *
 * @author ESOP Team 2019
 *
 */
public class CountDownAlarmClockView extends AlarmClockView {
    private static final long serialVersionUID = 1L;

    private static final int ALARM_PLAY_TIME = 1000;
    /**
     * Constructs a new view for the three specified {@link ChainedCounter} objects.
     *
     * This constructor sets up all the necessary GUI elements needed to display a digital count down alarm clock.
     *
     * @param hoursCounter the counter representing the hours
     * @param minsCounter the counter representing the minutes
     * @param secsCounter the counter representing the seconds
     * @param alarmH the value of the hoursCounter when the alarm should sound (is normally 0)
     * @param alarmM the value of the minsCounter when the alarm should sound (is normally 0)
     * @param alarmS the value of the secsCounter when the alarm should sound (is normally 0)
     */
    public CountDownAlarmClockView(ChainedCounter hoursCounter,
                                   ChainedCounter minsCounter, ChainedCounter secsCounter,
                                   int alarmH, int alarmM, int alarmS) {
        super(hoursCounter, minsCounter, secsCounter, alarmH, alarmM, alarmS);
    }

    /* (non-Javadoc)
     * @see counters.clocks.alarmclock.AlarmClockView#updateClock()
     */
    protected void updateClock(){
        // HERE call the super-version of updateClock() method. 
    	super.updateClock();
    	
        // HERE test if timer should be stopped! If so, call timer.stop(); 
    	if(alarmS == (secsCounter.getValue() - ALARM_PLAY_TIME) &&
                alarmM == (minsCounter.getValue() - ALARM_PLAY_TIME) &&
                alarmH == (hoursCounter.getValue() - ALARM_PLAY_TIME)){
    		System.out.println("STOP");
            timer.stop();
        }
    }
}
