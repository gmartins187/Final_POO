package Notes;
import java.util.*;

public abstract class noteWithContentAbstractClass extends noteAbstractClass implements NoteWithContent {

    private int numOfLinks;
    private String content;

    private final HashMap<Integer, NoteWithContent> linkedNotes;
    private final HashMap<String, referenceNoteClass> tags;

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
    public void setContent(String content, HashMap<String, NoteWithContent> notes){
        this.content = content;
        computeLinks(notes, content);
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void computeLinks(HashMap<String, NoteWithContent> notes, String content) {
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
                    notes.put(tmpNote.toString(), new permanentNoteClass(tmpNote.toString(), tmpContent, this.getDate(), notes));
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
    public void remove(int i) {
        StringBuilder tmpStr = new StringBuilder(content);
        tmpStr.deleteCharAt(i);
        content = tmpStr.toString();
    }

    @Override
    public void listLinks(){
        List<Integer> keys = new ArrayList<>(linkedNotes.keySet());
        for(Integer key : keys) {
            System.out.println(linkedNotes.get(key).getId());
        }
    }

    @Override
    public int getLinks() {
        return numOfLinks;
    }

    @Override
    public boolean hasTag(String tagId){
        return tags.containsKey(tagId);
    }

    @Override
    public void addTag(referenceNoteClass referenceNoteClass){
        tags.put(referenceNoteClass.getId(), referenceNoteClass);
    }

    @Override
    public void removeTag(referenceNoteClass tag){
        tags.remove(tag.getId());
    }

    @Override
    public boolean hasTags(){
        return !tags.isEmpty();
    }

    @Override
    public void listTags(){
        for(String name : tags.keySet()){
            System.out.println(name);
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
