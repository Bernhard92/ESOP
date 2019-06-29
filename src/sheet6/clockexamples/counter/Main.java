package sheet6.clockexamples.counter;
import javax.swing.*;
/**
 * This application provides a graphical user interface (GUI) to a {@link Counter} object. The {@link Counter} can
 * be operated by clicking on a "counter"-button and a "reset"-button.
 *
 * @author ESOP Team 2019
 *
 */
public class Main {
    public static void main(String[] args) {
        // a) Counter basic = new Counter(95);
        // b) Counter basic = new Counter(95, 100);

        Counter basic = new Counter(95, 100);

        CounterView view = new CounterView(basic);
        JFrame f = new JFrame("Counter");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(view);
        f.pack();
        f.setResizable(false);
        f.setVisible(true);
    }
}
