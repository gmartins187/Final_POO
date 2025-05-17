package Notes;

import App.dateClass;

import java.util.HashMap;

public abstract class noteWithContentAbstractClass extends abstractNoteClass implements NoteWithContent {

    private int numOfLinks;
    private String content;

    private final HashMap<String, NoteWithContent> linkedNotes;

    public noteWithContentAbstractClass(String id, String content, HashMap<String, NoteWithContent> notes) {
        super(id);
        this.content = content;
        linkedNotes = new HashMap<>();
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
}
