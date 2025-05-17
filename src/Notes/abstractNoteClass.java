package Notes;

public abstract class abstractNoteClass implements Note{

    private final String id;

    public abstractNoteClass(String id){
        this.id = id;
    }


    @Override
    public String getId() {
        return id;
    }
}
