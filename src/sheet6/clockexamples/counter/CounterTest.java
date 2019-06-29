package sheet6.clockexamples.counter;
/**
 * A test program to test the implementation of the {@link Counter} class.
 *
 * @author ESOP Team 2019
 *
 */
public class CounterTest {
    public static void main(String[] args) {
        Counter a = new Counter(10);
        Counter b = new Counter(5);
        System.out.println("a=" + a.getValue());
        System.out.println("b=" + b.getValue());
        a.count();
        System.out.println("a=" + a.getValue());
        a.reset();
        System.out.println("a=" + a.getValue());
    }
}
