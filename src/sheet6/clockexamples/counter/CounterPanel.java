package sheet6.clockexamples.counter;
import javax.swing.*;
import java.awt.*;
/**
 * Serves to visual display a {@link Counter} object in a the graphical user interface.
 *
 * Extends {@link JPanel}, hosts a {@link Counter} object.
 *
 * @author ESOP Team 2019
 *
 */
public class CounterPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private Counter counter;
    private Font font;

    /**
     * Creates a new CounterPanel to serve as visual host for the specified Counter.
     *
     * @param counter the counter
     */
    public CounterPanel(Counter counter) {
        this.counter = counter;
        setPreferredSize(new Dimension(190,130));
        setBackground(Color.BLACK);
        setOpaque(true);
        font = new Font("Monospaced",Font.BOLD,140);
    }

    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(font);
        int val = counter.getValue();
        if (val < 10) g.drawString("0" + val,10,110);
        else g.drawString("" + val,10,110);
    }
}
