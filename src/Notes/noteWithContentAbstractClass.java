package Notes;

import java.util.HashMap;

public abstract class noteWithContentAbstractClass extends noteAbstractClass implements NoteWithContent {

    private int numOfLinks;
    private String content;

    private final HashMap<String, NoteWithContent> linkedNotes;
    private final HashMap<String, referenceNoteClass> tags;

    public noteWithContentAbstractClass(String id, String content, HashMap<String, NoteWithContent> notes) {
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
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == '[') {
                i+=2;
                while (content.charAt(i) != ']') {
                    tmpNote.append(content.charAt(i));
                    i++;
                }
                if(!linkedNotes.containsKey(tmpNote.toString())){
                    linkedNotes.put(tmpNote.toString(), notes.get(tmpNote.toString()));
                    numOfLinks++;
                }
                tmpNote = new StringBuilder();
            }
        }
    }
    
    @Override
    public void iterateLinks(){
        for(String name : linkedNotes.keySet()){;
            System.out.println(name);
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
        return linkedNotes.containsKey(id);
    }

    @Override
    public void removeLink(String id){
        linkedNotes.remove(id);
    }

    @Override
    public int getTags(){
        return tags.size();
    }
}
