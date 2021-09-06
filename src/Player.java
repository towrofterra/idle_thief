import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

/**
 * A Player has Resources & Generators
 */
public class Player {

    //////////////
    /// FIELDS ///
    //////////////

    private HashMap<IResource, Integer> resources;
    private HashMap<IGenerator, Integer> generators;
    String name;

    ///////////////////////
    /// GETTERS/SETTERS ///
    ///////////////////////

    public HashMap<IResource, Integer> getResources() {
        return resources;
    }

    public void setResources(HashMap<IResource, Integer> resources) {
        this.resources = resources;
    }

    public HashMap<IGenerator, Integer> getGenerators() {
        return generators;
    }

    public void setGenerators(HashMap<IGenerator, Integer> generators) {
        this.generators = generators;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ////////////////////
    /// CONSTRUCTORS ///
    ////////////////////

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

    ///////////////
    /// UTILITY ///
    ///////////////



    ////////////////////////////////
    /// RESOURCES AND GENERATORS ///
    ////////////////////////////////


    /**
     * Sets the resources and generators of this Player to zero.
     */
    public void zeroResourcesAndGenerators() {
        this.resources = new HashMap<>();
        this.generators = new HashMap<>();
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