import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

/**
 * A Player has Resources & Generators
 */
public class Player {
    public HashMap<IResource, Integer> resources;
    public HashMap<IGenerator, Integer> generators;
    String name;

    /**
     * Sets the resources and generators of this Player to zero.
     */
    private void zeroResourcesAndGenerators() {
        this.resources = new HashMap<>();
        this.generators = new HashMap<>();
    }

    /**
     * Default Player constructor
     */
    public Player() {
        this.name = "";
        zeroResourcesAndGenerators();;
    }

    /**
     * Player constructor with name
     */
    public Player(String name) {
        this.name = name;
        zeroResourcesAndGenerators();
    }

    /**
     * Adds the given generator to this Player
     * @param generator The generator to be added.
     */
    public void addGenerator(IGenerator generator) {
        if(this.generators.containsKey(generator)) {
            this.generators.get(generator)
        }
    }

}