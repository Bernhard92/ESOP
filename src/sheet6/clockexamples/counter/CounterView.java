package sheet6.clockexamples.counter;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
/**
 * A part of the graphical user interface used to interact with a {@link Counter}. Used by the
 * {@link Main} application.
 *
 * Extends {@link JPanel}, hosts and manages one {@link Counter} object and provides buttons
 * for user interaction.
 *
 * @author ESOP Team 2019
 *
 */
public class CounterView extends JPanel {
    private static final long serialVersionUID = 1L;
    private Counter counter;
    private CounterPanel panel;

    /**
     * Constructs a new view for the specified {@link Counter} object.
     *
     * This constructor sets up all the necessary GUI elements needed to manipulate the {@link Counter} (a "count"-button
     * and a "reset"-button).
     *
     * @param counter the {@link Counter} that should be displayed in the view.
     */
    public CounterView (Counter counter) {
        this.counter = counter;
        panel = new CounterPanel(counter);
        JButton countButton = new JButton("Count");
        JButton resetButton = new JButton("Reset");
        countButton.addActionListener(new CountListener());
        resetButton.addActionListener(new ResetListener());
        setLayout(new BorderLayout());
        add(panel,BorderLayout.NORTH);
        add(countButton,BorderLayout.WEST);
        add(resetButton,BorderLayout.EAST);
        setOpaque(true);
    }

    private class CountListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            counter.count();
            panel.repaint();
        }
    }

    private class ResetListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            counter.reset();
            panel.repaint();
        }
    }
}
