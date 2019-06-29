package sheet6.clockexamples.clock;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * A part of the graphical user interface used by the {@link MainClock} application.
 *
 * Extends {@link JPanel}, hosts and manages three {@link ChainedCounter} objects.
 *
 * @author ESOP Team 2019
 *
 */
public class ClockView extends JPanel {

    private static final long serialVersionUID = 1L;
    protected ChainedCounter secsCounter;
    protected ChainedCounter minsCounter;
    protected ChainedCounter hoursCounter;
    protected Timer timer;

    /**
     * Constructs a new view for the three specified {@link ChainedCounter} objects.
     *
     * This constructor sets up all the necessary GUI elements needed to display a digital clock.
     *
     * @param hoursCounter the counter representing the hours
     * @param minsCounter the counter representing the minutes
     * @param secsCounter the counter representing the seconds
     */
    public ClockView(ChainedCounter hoursCounter,
                     ChainedCounter minsCounter,
                     ChainedCounter secsCounter){
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
    }

    /**
     * Is called by the {@link Timer} object each second. Updates the digital clock.
     */
    protected void updateClock(){
        secsCounter.count();
        repaint();
    }
}
