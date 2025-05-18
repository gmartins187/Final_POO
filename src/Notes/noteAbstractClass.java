package Notes;

public abstract class noteAbstractClass implements Note{

    private final String id;

    public noteAbstractClass(String id){
        this.id = id;
    }


    @Override
    public String getId() {
        return id;
    }
}
