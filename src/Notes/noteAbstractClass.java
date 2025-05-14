package Notes;

public abstract class noteAbstractClass implements Note{

    private final String ID;

    public noteAbstractClass(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }
}
