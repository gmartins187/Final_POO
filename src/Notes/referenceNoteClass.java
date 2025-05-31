package Notes;

import java.util.*;


public class referenceNoteClass extends noteAbstractClass implements ReferenceNote{

    private final Map<String, NoteWithContent> notesTaggedOn;
    private int roundNum;
    private static int round;

    /**
     * Constructor for the referenceNoteClass. Creates a new reference note.
     * @param id the id of the note
     */
    public referenceNoteClass(String id) {
        super(id);
        notesTaggedOn = new HashMap<>();
    }

    @Override
    public void insertNote(String noteId, NoteWithContent note){
        notesTaggedOn.put(noteId, note);
        round++;
        roundNum = round;
    }

    @Override
    public void iterateNotesTaggedOn() {
        List<String> note = new ArrayList<>(notesTaggedOn.keySet());
        Collections.sort(note);
        for(String notes : note){
            System.out.println(notes);
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
        round++;
        roundNum = round;
    }

    @Override
    public int getTheRound() {
        return roundNum;
    }


}
