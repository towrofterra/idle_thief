/**
 * An AGenerator can generate the IResource it is typed with
 */
public class Generator implements IGenerator {

    private final String type;

    public Generator(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public boolean equals(Object anObject) {
        return anObject instanceof Generator && this.getType().equals(((Generator)anObject).getType());
    }
}
