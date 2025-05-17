package Notes;

import App.dateClass;

import java.util.HashMap;

public class referenceNoteClass extends abstractNoteClass implements ReferenceNote{

    HashMap<String, NoteWithContent> notesTaggedOn;

    public referenceNoteClass(String id) {
        super(id);
    }

    public void insertNote(String noteId, NoteWithContent note){
        notesTaggedOn.put(noteId, note);
    }

    @Override
    public void iterateNotesTaggedOn() {
        for(String noteName : notesTaggedOn.keySet()){
            System.out.println(noteName);
        }
    }

    @Override
    public int getNumTags() {
        return notesTaggedOn.size();
    }
}
