public class AResource implements IResource {

    private String type;

    @Override
    public String getType() {
        return type;
    }


    @Override
    public boolean equals(Object o) {
        try {
            return this.getType().equals(((IResource) o).getType());
        } catch (ClassCastException e) {
            return false;
        }
    }
}