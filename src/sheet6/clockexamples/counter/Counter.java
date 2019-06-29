package sheet5.clockexamples.counter;
/**
 * A counter with basic functionality.
 *
 * @author ESOP Team 2019
 *
 */
public class Counter {
    protected int value;
    /**
     * Constructor
     * Constructs a counter and initializes the counter value to 0.
     */
    //a)
    public Counter(int init){
    	value = init;
    }

    //b)
    protected int modulo;
    public Counter(int init, int modulo){
        this.value = init;
        this.modulo = modulo;
    }
    /**
     * Increments the counter value by 1.
     */

    // a)
    //public void count(){
    //	value++;
    //}

    //b)
    public void count() {
        value = (value+1) % modulo;
        //Or...
		/*if(value == modulo - 1){
			value = 0;
		}else{
			value++;
		}*/
    }

    /**
     * Resets the counter value to 0.
     */
    public void reset(){
        value = 0;
    }

    /**
     * Returns the current counter value
     *
     * @return the value
     */
    public int getValue(){
        return value;
    }
}

