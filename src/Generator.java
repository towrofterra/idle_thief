/**
 * An AGenerator can generate the IResource it is typed with
 */
public class Generator implements IGenerator {

    private final Game.RESOURCE_TYPES type;

    public Generator(Game.RESOURCE_TYPES type) {
        this.type = type;
    }

    public Game.RESOURCE_TYPES getType() {
        return this.type;
    }

    @Override
    public boolean equals(Object anObject) {
        return anObject instanceof Generator && this.getType().equals(((Generator)anObject).getType());
    }
}
