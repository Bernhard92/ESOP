package sheet6.clockexamples.clock;
/**
 * A counter which value is bounded. When its value reaches a specified bound, the value is automatically reset to 0
 * and the count() method of its chained counter is invoked.
 *
 * @author ESOP Team 2019
 *
 */
public class ChainedCounter {
    protected int value;
    protected int modulo;
    protected ChainedCounter next;

    /**
     * Creates a counter with its value initialized to the specified value and having a specified maximum value.
     * The next counter will be called when the value is 0.
     *
     * @param init the initial value
     * @param modulo the maximum (bound) of the counter
     * @param next the chained counter
     */
    public ChainedCounter(int init, int modulo, ChainedCounter next){
        this.value = init;
        this.modulo = modulo;
        this.next = next;
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


    /* (non-Javadoc)
     * @see counters.simple.BoundedCounter#count()
     */
    public void count() {
        //value = (value+1) % modulo;

        if(value == modulo - 1){
            value = 0;
        }else{
            value++;
        }

        if(value == 0 && next != null){
            next.count();
        }
    }
}
