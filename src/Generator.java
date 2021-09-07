/**
 * An AGenerator can generate the IResource it is typed with
 */
public class Generator<R extends AResource> implements IGenerator {

    private R type;

    public Generator(R type) {
        this.type = type;
    }

    public String getType() {
        return this.type.getType();
    }

    public R getResource() {
        return this.type;
    }
}
