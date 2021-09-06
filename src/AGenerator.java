/**
 * An AGenerator can generate the IResource it is typed with
 */
public abstract class AGenerator<IResource> implements IGenerator {
    private int rate;

    public AGenerator() {
        this.rate = 0;
    }

    public AGenerator(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
}
