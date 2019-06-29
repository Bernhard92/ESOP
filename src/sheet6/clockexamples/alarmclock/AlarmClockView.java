package sheet6.clockexamples.alarmclock;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import sheet6.clockexamples.clock.ChainedCounter;
import sheet6.clockexamples.clock.CounterClockPanel;



/**
 * A part of the graphical user interface used by the {@link MainAlarmClock} application.
 *
 * Extends {@link JPanel}, hosts and manages three {@link ChainedCounter} objects.
 *
 * @author ESOP Team 2019
 *
 */
public class AlarmClockView extends JPanel {
    private static final long serialVersionUID = 1L;
    protected ChainedCounter secsCounter;
    protected ChainedCounter minsCounter;
    protected ChainedCounter hoursCounter;
    protected Timer timer;

    protected int alarmH;
    protected int alarmM;
    protected int alarmS;

    /**
     * Constructs a new view for the three specified {@link ChainedCounter} objects.
     *
     * This constructor sets up all the necessary GUI elements needed to display a digital alarm clock.
     *
     * @param hoursCounter the counter representing the hours
     * @param minsCounter the counter representing the minutes
     * @param secsCounter the counter representing the seconds
     * @param alarmH the hour of the alarm
     * @param alarmM the minute of the alarm
     * @param alarmS the second of the alarm
     */
    public AlarmClockView(ChainedCounter hoursCounter,
                          ChainedCounter minsCounter,
                          ChainedCounter secsCounter, int alarmH, int alarmM, int alarmS) {
        this.hoursCounter = hoursCounter;
        this.minsCounter = minsCounter;
        this.secsCounter = secsCounter;

        CounterClockPanel hours = new CounterClockPanel(hoursCounter);
        CounterClockPanel mins = new CounterClockPanel(minsCounter);
        CounterClockPanel secs = new CounterClockPanel(secsCounter);
        mins.setBackground(Color.GRAY);

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(570,130));
        add(hours,BorderLayout.WEST);
        add(mins,BorderLayout.CENTER);
        add(secs,BorderLayout.EAST);

        timer = new Timer(1000,new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                updateClock();
            }
        });
        timer.start();

        this.alarmH = alarmH;
        this.alarmM = alarmM;
        this.alarmS = alarmS;
    }

    /* (non-Javadoc)
     * @see counters.clocks.ClockView#updateClock()
     */
    protected void updateClock() {
        secsCounter.count();
        repaint();

        if(alarmS == secsCounter.getValue() &&
                alarmM == minsCounter.getValue() &&
                alarmH == hoursCounter.getValue()){
            new AudioStreamPlayer().play("src\\sheet5\\clockexamples\\alarmclock\\alarm.wav");
        }
    }
}
