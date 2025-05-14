package Notes;
import App.*;

public class permanentNoteClass extends noteAbstractClass implements PermanentNote{


    public permanentNoteClass(String content, dateClass date) {
        super(date, content);
    }
}
