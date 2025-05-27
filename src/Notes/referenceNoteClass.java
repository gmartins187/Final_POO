package Notes;

import java.util.*;


public class referenceNoteClass extends noteAbstractClass implements ReferenceNote{

    Map<String, NoteWithContent> notesTaggedOn;

    public referenceNoteClass(String id) {
        super(id);
        notesTaggedOn = new HashMap<>();
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

    @Override
    public boolean containsNote(String id) {
        return notesTaggedOn.containsKey(id);
    }

    @Override
    public void removeLink(String id) {
        notesTaggedOn.remove(id);
    }
}
