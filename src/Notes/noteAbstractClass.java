package Notes;

public abstract class noteAbstractClass implements Note{

    private final String id;


    /**
     * This method constructs a new note with an id.
     * @param id the id of the note
     */
    public noteAbstractClass(String id){
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}
