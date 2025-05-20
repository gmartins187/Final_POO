package App;

import java.time.chrono.ChronoLocalDate;
import java.util.HashMap;
import java.time.LocalDate;
import EnumClasses.*;
import Exceptions.*;
import Notes.*;



public class notesAppClass implements NotesApp{

    private final HashMap<String, NoteWithContent> notes;
    private final HashMap<String, referenceNoteClass> tags;
    private LocalDate currentDate;

    private static final String LITERATURE = "literature";
    private static final String PERMANENT = "permanent";


    /**
     * Constructor for the notesAppClass. Creates a new HashMap to store the notes.
     */
    public notesAppClass() {
        notes = new HashMap<>();
        tags = new HashMap<>();
    }

    @Override
    public void addPermanentNote(String kind, String ID, String content, LocalDate date) throws ExistentProblem, TimeTravelling {
        if(notes.containsKey(ID)){
            throw new ExistentProblem();
        }if(currentDate != null && date.isBefore(currentDate)){
            throw new TimeTravelling();
        } else{
            notes.put(ID, new permanentNoteClass(ID, content, date, notes));
            currentDate = date;

            System.out.println("Note " + ID + TerminalOutputs.CREATED.output + notes.get(ID).getLinks() + " notes.");
        }
    }

    @Override
    public void addLiteratureNote(String kind, String ID, String content, LocalDate date, String workTitle, String authorName, LocalDate pubDate, String quote, String url)
            throws ExistentProblem, TimeTravelling , TimeTravelToTheFuture{
        if(notes.containsKey(ID)){
            throw new ExistentProblem();
        } if (currentDate != null && date.isBefore(currentDate)){
            throw new TimeTravelling();
        } if (currentDate != null && pubDate.isAfter(currentDate)) {
            throw new TimeTravelToTheFuture();
        } else{
            notes.put(ID, new literaryNoteClass(ID, content, date, notes, workTitle, authorName, pubDate, quote, url));
            currentDate = date;

            System.out.println("Note " + ID + TerminalOutputs.CREATED.output + notes.get(ID).getLinks() + " notes.");
        }
    }

    @Override
    public void getContent(String ID) throws DoesNotExist{
        if(notes.containsKey(ID)){
            NoteWithContent note = notes.get(ID);
            System.out.println(note.getContent() + " " + note.getLinks() + " links. " + note.getTags() + " tags.");
        } else throw new DoesNotExist();
    }

    @Override
    public void updateNote(String id, LocalDate date, String content) throws TimeTravelling, DoesNotExist{
        if(!notes.containsKey(id)){
            throw new DoesNotExist();
        } if(date.isBefore(currentDate)){
            throw new TimeTravelling();
        } else {
            NoteWithContent note = notes.get(id);

            note.setContent(content, notes);
            note.setDate(date);
            currentDate = date;

            System.out.println("Note " + id + TerminalOutputs.UPDATED.output + notes.get(id).getLinks() + " links.");
        }
    }

    @Override
    public void listLinks(String id) throws DoesNotExist, NoNotes {
        if(!notes.containsKey(id)){
            throw new DoesNotExist();
        } if (notes.get(id).getLinks() == 0){
            throw new NoNotes();
        } else{
            notes.get(id).iterateLinks();
        }
    }

    @Override
    public void newTagNote(String id, String tagId) throws ExistentProblem, DoesNotExist{
        if(!notes.containsKey(id)){
            throw new DoesNotExist();
        } if(notes.get(id).hasTag(tagId)){
            throw new ExistentProblem();
        } else{
            referenceNoteClass tag = new referenceNoteClass(tagId);

            notes.get(id).addTag(tag);
            tags.put(tagId, tag);

            tag.insertNote(id, notes.get(id));

            System.out.println(id + TerminalOutputs.TAGGED_WITH.output + tagId + "!");
        }
    }

    @Override
    public void untagNote(String id, String tagId) throws ExistentProblem, DoesNotExist{
        if(notes.containsKey(id)){
            if(notes.get(id).hasTag(tagId)){
                referenceNoteClass tag = tags.get(tagId);

                notes.get(id).removeTag(tag);

                System.out.println("Note " + id + TerminalOutputs.REMOVED_TAG.output + tagId + "!");
            } else throw new ExistentProblem();
        } else throw new DoesNotExist();
    }

    @Override
    public void listTags(String id) throws DoesNotExist, NoNotes{
        if(notes.containsKey(id)) {
            if(notes.get(id).hasTags()) {
                notes.get(id).listTags();
            } else throw new NoNotes();
        } else throw new DoesNotExist();
    }

    @Override
    public void listTaggedOn(String tagId) throws ExistentProblem{
        if(tags.containsKey(tagId)){
            tags.get(tagId).iterateNotesTaggedOn();
        } else throw new ExistentProblem();
    }

    @Override
    public void trending() {
        int max = 0;
        if(!tags.isEmpty()) {
            for (ReferenceNote tag : tags.values()) {
                if (max < tag.getNumTags()) {
                    max = tag.getNumTags();
                }
            }
            for (String tag : tags.keySet()){
                if(max == tags.get(tag).getNumTags()){
                    System.out.println(tag);
                }
            }
        } else throw new NoTagsDefined();
    }

    @Override
    public void remove(String id) throws DoesNotExist{
        if(notes.containsKey(id) || tags.containsKey(id)){
            if(notes.containsKey(id)){
                removeNote(id);
            } else {
                removeTag(id);
            }
            System.out.println("Note " + id + TerminalOutputs.DELETED.output);
        } else throw new DoesNotExist();
    }

    @Override
    public void getNotesFromTo(String kind, LocalDate startDate, LocalDate endDate)
            throws UnknownKind, TimeTravelling {
        if(!kind.equalsIgnoreCase(PERMANENT) && !kind.equalsIgnoreCase(LITERATURE)){
            throw new UnknownKind();
        } if (startDate.isAfter(endDate)){
            throw new TimeTravelling();
        } else {
            for(String noteName : notes.keySet()){
                if(notes.get(noteName).isDateInBetween(startDate, endDate))
                    System.out.println(noteName);
            }
        }
    }

    /**
     * removes a reference note from the system
     * @param id the id of the reference note
     */
    private void removeTag(String id) {
        for(NoteWithContent note : notes.values()){
            if(note.hasTag(id)){
                note.removeTag(tags.get(id));
            }
        }
        tags.remove(id);
    }

    /**
     * removes a permanent or a literary note from the system
     * @param id the id of the note to remove
     */
    private void removeNote(String id) {
        for (NoteWithContent note : notes.values()) {
            if(note.containsNote(id)){
                note.removeLink(id);
            }
        }
        for(ReferenceNote note : tags.values()){
            if(note.containsNote(id)){
                note.removeLink(id);
            }
        }
        notes.remove(id);
    }
}
