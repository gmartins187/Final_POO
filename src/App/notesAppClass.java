package App;
import java.util.HashMap;

import EnumClasses.*;
import Exceptions.*;
import Notes.*;


public class notesAppClass implements NotesApp{

    private final HashMap<String, Note> notes;
    private dateClass currentDate;

    public notesAppClass() {
        notes = new HashMap<>();
    }

    @Override
    public void createNote(String kind, String ID, String content, dateClass date) throws ExistentID, TimeTravelling{
        if(!hasNote(ID)) {
            if(date.isValid()) {
                if (!date.isBefore(currentDate)) {
                    Note note = NotesTypes.CreateNote(kind, content, date);
                    notes.put(ID, note);
                    currentDate = new dateClass(date.getDay(), date.getMonth(), date.getYear());
                    System.out.println("Note " + ID + TerminalOutputs.CREATED.output + note.getLinks(notes) + " notes.");
                } else throw new TimeTravelling();
            } else throw new InvalidDate();
        } else throw new ExistentID();
    }

    @Override
    public boolean hasNote(String id) {
        return notes.containsKey(id);
    }

    @Override
    public dateClass getCurrentDate() {
        return currentDate;
    }

    @Override
    public void updateCurrentDate(int day, int month, int year) {
        if(currentDate == null)
            currentDate = new dateClass(day, month, year);
        else currentDate.updateDate(day, month, year);
    }
}
