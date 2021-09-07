public interface IGenerator {

    /**
     * Get the type of this IGenerator
     * @return A String representing the type of this IGenerator
     */
    public String getType();

    /**
     * Get the IResource this IGenerator generates
     * @return The IResource this IGenerator generates
     */
    public IResource getResource();

}
