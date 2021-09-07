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
        zeroResourcesAndGenerators();
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
     * Get the status of this player i.e. Resources and Generators
     * @return A String representing the status of this Player
     */
    public String getStatus() {
        // Add player name & Generator heading
        StringBuilder str = new StringBuilder("Player name: " + getName() + "\nGenerators:\n");
        // Add generator info
        for(IGenerator gen : generators.keySet()) {
            int numGens = generators.get(gen);
            str.append("\t").append(gen.getType()).append(": ").append(numGens).append("\n");
        }
        // Add resource info
        for(IResource res : resources.keySet()) {
            int num = resources.get(res);
            str.append("\t").append(res.getType()).append(": ").append(num).append("\n");
        }
        return str.toString();
    }

    /**
     * Sets the resources and generators of this Player to zero.
     */
    public void zeroResourcesAndGenerators() {
        this.resources = new HashMap<>();
        this.generators = new HashMap<>();
    }

    /**
     * Adds the given generator to this Player's list of generators
     * If it already exists, increments the number of generators
     * @param generator The generator to be added.
     */
    public void addGenerator(IGenerator generator) {
        if(this.generators.containsKey(generator)) {
            int currNumGens = this.generators.get(generator);
            this.generators.put(generator, currNumGens + 1);
        } else {
            this.generators.put(generator, 1);
        }
    }

    /**
     * Adds the given generator to this Player's list of generators the given number of times
     * If it already exists, increments the number of generators
     * @param generator The generator to be added.
     * @param num The number of times to add the generator.
     */
    public void addGenerators(IGenerator generator, int num) {
        if(this.generators.containsKey(generator)) {
            int currNumGens = this.generators.get(generator);
            this.generators.put(generator, currNumGens + num);
        } else {
            this.generators.put(generator, num);
        }
    }

    /**
     * Adds the given number of resources to this player
     * @param resource The resource to add
     * @param num The amount to add.
     */
    public void addResources(IResource resource, int num) {
        if(this.resources.containsKey(resource)) {
            int currNumGens = this.resources.get(resource);
            this.resources.put(resource, currNumGens + num);
        } else {
            this.resources.put(resource, num);
        }
    }

    /**
     * Move this Player forward 1 tick in time
     */
    public void tick() {
        // Each generator adds 1 to the relevant resource
        for(IGenerator generator : this.generators.keySet()) {
            IResource type = generator.getResource();

            // If the player already has the resource
            if(this.resources.containsKey(type)) {
                int prev = this.resources.get(type);
                // The number of generators is the value mapped to the generator in this.generators
                int numGens = this.generators.get(generator);
                this.resources.put(type, prev + numGens);
            }

            // If it's a new resource
            else {
                int numGens = this.generators.get(generator);
                this.resources.put(type, numGens);
            }
        }

        // Print status to console
        System.out.println(this.getStatus());

    }

}