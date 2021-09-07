/**
 * Class to represent the cash resource
 */
public class CashResource extends AResource {



    int value;

    /**
     * Constructor with no value, defaults to 0
     */
    public CashResource() {
        this.value = 0;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String getType() {
        return "Cash";
    }
}
