package sheet6.clockexamples.countdownalarm;

import sheet6.clockexamples.clock.ChainedCounter;

/**
 * Works as a {@link ChainedCounter} but is counting backwards, i.e., its value decreases by one
 * for each call to the count method. When its value reaches 0, the value is automatically reset to the value
 * specified by its modulo variable and the count() method of its chained counter is invoked.
 *
 * @author ESOP Team 2019
 *
 */
public class ChainedCountDownCounter extends ChainedCounter {

    /**
     * Creates a counter with its value initialized to the specified value and having a specified maximum value.
     * The next counter will be called when the value is 0.
     *
     * @param init the initial value
     * @param modulo the maximum (bound) of the counter
     * @param next the chained counter
     */
    public ChainedCountDownCounter(int init, int modulo, ChainedCountDownCounter next) {
        super(init, modulo, next);
    }

    // Implement method count() which counts reverse!
    // This method overwrites the count() method in class ChainedCounter from exercise 21 UB4.	
    public void count() {
    	System.out.println(value);
    	if(value == -1)
    		value = modulo-1;
    	if(value == modulo-1 && next != null) {
    		next.count();
    	}
    }

}
