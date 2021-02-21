package entities;

public class AbstractEntity {
    private int id;

    /**
     * @return entity's id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id of the entity
     */
    public void setId(final int id) {
        this.id = id;
    }


    /**
     * For debugging
     */
    @Override
    public String toString() {
        return "AbstractEntity{"
                + "id="
                + id
                + '}';
    }
}
