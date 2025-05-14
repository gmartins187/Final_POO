package Notes;
import App.*;

public class literaryNoteClass extends noteAbstractClass implements LiteraryNote{

    public literaryNoteClass(String content, dateClass date) {
        super(date, content);
    }
}
