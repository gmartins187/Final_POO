package Notes;

import java.util.*;

public abstract class noteWithContentAbstractClass extends noteAbstractClass implements NoteWithContent {

    private int numOfLinks;
    private String content;

    private Map<Integer, NoteWithContent> linkedNotes;
    private final Map<String, ReferenceNote> tags;

    /**
     * This method constructs a new note with content and other capacities
     * @param id the id of the note
     * @param content the content of the note
     */
    public noteWithContentAbstractClass(String id, String content) {
        super(id);
        this.content = content;
        linkedNotes = new HashMap<>();
        tags = new HashMap<>();
    }


    @Override
    public void setContent(String content, Map<String, NoteWithContent> notes){
        this.content = content;
        this.computeLinks(notes, content);
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void computeLinks(Map<String, NoteWithContent> notes, String content) {
        linkedNotes = new HashMap<>();
        numOfLinks = 0;
        StringBuilder tmpNote = new StringBuilder();
        String tmpContent;
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == '[') {
                i +=2;
                while (content.charAt(i) != ']') {
                    tmpNote.append(content.charAt(i));
                    i++;
                }
                if(!notes.containsKey(tmpNote.toString())) {
                    tmpNote.append('.');
                    tmpContent = tmpNote.toString();
                    tmpNote.deleteCharAt(tmpNote.length()-1);
                    notes.put(tmpNote.toString(),
                            new permanentNoteClass(tmpNote.toString(), tmpContent, this.getDate(), notes));
                }
                if (!linkedNotes.containsValue(notes.get(tmpNote.toString()))) {
                    linkedNotes.put(numOfLinks, notes.get(tmpNote.toString()));
                    numOfLinks++;
                }
                tmpNote = new StringBuilder();
            }
        }
        this.content = this.content.replace("[", "").replace("]", "");
    }

    @Override
    public void listLinks(){
        List<Integer> keys = new ArrayList<>(linkedNotes.keySet());
        Collections.sort(keys);
        for(Integer key : keys) {
            System.out.println(linkedNotes.get(key).getId());
        }
    }

    @Override
    public int getLinks() {
        return numOfLinks;
    }

    @Override
    public boolean containsTag(String tagId){
        return tags.containsKey(tagId);
    }

    @Override
    public void addTag(ReferenceNote note){
        tags.put(note.getId(), note);
    }

    @Override
    public void removeTag(ReferenceNote tag){
        for (ReferenceNote note : tags.values()) {
            if (note.equals(tag)) {
                tags.values().remove(note);
                break;
            }
        }
    }

    @Override
    public boolean hasTags(){
        return !tags.isEmpty();
    }

    @Override
    public void listTags(){
        List<String> noteNames = new ArrayList<>(tags.keySet());
        Collections.sort(noteNames);
        for(String noteName : noteNames) {
            System.out.println(noteName);
        }
    }

    @Override
    public boolean containsNote(String id){
        for (NoteWithContent note : linkedNotes.values()) {
            if (note.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeLink(String id){
        for (NoteWithContent note : linkedNotes.values()) {
            if (note.getId().equals(id)) {
                linkedNotes.values().remove(note);
                numOfLinks--;
                break;
            }
        }
    }

    @Override
    public int getTags(){
        return tags.size();
    }

    @Override
    public String getId(){
        return super.getId();
    }
}
