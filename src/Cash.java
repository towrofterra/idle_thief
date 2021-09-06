/**
 * Class to represent the cash resource
 */
public class Cash implements IResource{
    private int value;

    /**
     * Constructor with no value, defaults to 0
     */
    public Cash() {
        this.value = 0;
    }

    /**
     * Constructor with value
     * @param value
     */
    public Cash(int value) {
        this.value = value;
    }

    /**
     * @return value of this cash
     */
    public int getValue() {
        return value;
    }

    @Override
    public String getResourceName() {
        return "Cash";
    }
}
