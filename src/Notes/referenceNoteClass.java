package Notes;

import java.util.HashMap;

public class referenceNoteClass extends noteAbstractClass implements ReferenceNote{

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

    @Override
    public boolean containsNote(String id) {
        return notesTaggedOn.containsKey(id);
    }

    @Override
    public void removeLink(String id) {
        notesTaggedOn.remove(id);
    }
}
