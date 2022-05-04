import java.util.HashMap;

/**
 * A Player has Resources & Generators
 */
public class Player {

    //////////////
    /// FIELDS ///
    //////////////

    String name;
    private HashMap<Game.RESOURCE_TYPES, Integer> resources;
    private HashMap<Game.RESOURCE_TYPES, Integer> generators;

    ///////////////////////
    /// GETTERS/SETTERS ///
    ///////////////////////

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

    private HashMap<Game.RESOURCE_TYPES, Integer> getResources() {
        return resources;
    }

    private void setResources(HashMap<Game.RESOURCE_TYPES, Integer> resources) {
        this.resources = resources;
    }

    private HashMap<Game.RESOURCE_TYPES, Integer> getGenerators() {
        return generators;
    }

    private void setGenerators(HashMap<Game.RESOURCE_TYPES, Integer> generators) {
        this.generators = generators;
    }

    ////////////////////
    /// CONSTRUCTORS ///
    ////////////////////

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ///////////////
    /// UTILITY ///
    ///////////////


    ////////////////////////////////
    /// RESOURCES AND GENERATORS ///
    ////////////////////////////////

    /**
     * Get the status of this player i.e. Resources and Generators
     *
     * @return A String representing the status of this Player
     */
    public String getStatus() {
        // Add player name & Generator heading
        StringBuilder str = new StringBuilder("Player name: " + getName() + "\nGenerators:\n");
        // Add generator info
        for (Game.RESOURCE_TYPES gen : generators.keySet()) {
            int numGens = generators.get(gen);
            str.append("\t").append(gen).append(": ").append(numGens).append("\n");
        }
        // Add resource info
        str.append("Resources:\n");
        for (Game.RESOURCE_TYPES res : resources.keySet()) {
            int num = resources.get(res);
            str.append("\t").append(res).append(": ").append(num).append("\n");
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

//    /**
//     * Adds the given generator to this Player's list of generators
//     * If it already exists, increments the number of generators
//     *
//     * @param generator The generator to be added.
//     */
//    public void addGenerator(IGenerator generator) {
//        if (this.generators.containsKey(generator)) {
//            int currNumGens = this.generators.get(generator);
//            this.generators.put(generator, currNumGens + 1);
//        } else {
//            this.generators.put(generator, 1);
//        }
//    }

    /**
     * Adds the given generator to this Player's list of generators the given number of times
     * If it already exists, increments the number of generators
     *
     * @param generator The generator to be added.
     * @param num       The number of times to add the generator.
     */
    public void addGenerators(Game.RESOURCE_TYPES resourceType, int num) {
        for (Game.RESOURCE_TYPES existingGenerator : this.generators.keySet()) {
            if (existingGenerator.equals(resourceType)) {
                int currNumGens = this.generators.get(resourceType);
                this.generators.put(resourceType, currNumGens + num);
                return;
            }
        }
        this.generators.put(resourceType, num);
    }


    /**
     * Adds the given number of resources to this player
     *
     * @param resource The resource to add
     * @param num      The amount to add.
     */
    public void addResources(Game.RESOURCE_TYPES resource, int num) {
        int currNumResources = this.getResourceStatus(resource);
        if (currNumResources > 0) {
            this.resources.put(resource, currNumResources + num);
        } else {
            this.resources.put(resource, num);
        }
    }

    /**
     * Removes the given number of resources to this player.
     *
     * @param resource The resource to remove.
     * @param num      The amount to remove.
     */
    public void removeResources(Game.RESOURCE_TYPES resource, int num) {
        if (this.resources.containsKey(resource)) {
            int currNumResources = this.getResourceStatus(resource);
            this.resources.put(resource, currNumResources - num);
        }
    }

    /**
     * Gets the number of generators for the given resource this player has
     *
     * @param resource The generator type to find
     * @return An int representing the number of generators this Player has of the given resource.
     */
    public int getNumGens(Game.RESOURCE_TYPES resource) {
        return this.generators.getOrDefault(resource, 0);
    }

    /**
     * Gets the value of the given resource
     *
     * @param targetResource The resource to value
     * @return The value of the given resource, or 0 if the resource is not found.
     */
    public int getResourceStatus(Game.RESOURCE_TYPES targetResource) {
        for (Game.RESOURCE_TYPES resource : this.resources.keySet()) {
            if (targetResource.equals(resource)) {
                return resources.get(resource);
            }
        }
        return 0;
    }

    /**
     * Move this Player forward 1 tick in time
     */
    public void tick() {
        // Each generator adds 1 to the relevant resource
        for (Game.RESOURCE_TYPES generator : this.generators.keySet()) {
            Game.RESOURCE_TYPES type = generator;

            // If the player already has the resource
            if (this.resources.containsKey(type)) {
                int prev = this.getResourceStatus(type);
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
        util.debug(this.getStatus());

    }

}