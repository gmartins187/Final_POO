package Notes;
import App.*;

import java.util.HashMap;

public abstract class noteAbstractClass implements Note{

    private final dateClass date;
    private final String content;
    private int numOfLinks;

    private final HashMap<String, Note> linkedNotes;

    public noteAbstractClass(dateClass date, String content, HashMap<String, Note> notes) {
        this.date = date;
        this.content = content;
        linkedNotes = new HashMap<>();
        addLinks(notes);
    }

    public void addLinks(HashMap<String, Note> notes) {
        StringBuilder tmpNote = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == '[') {
                i++;
                while (content.charAt(i) != ']') {
                    tmpNote.append(content.charAt(i));
                    i++;
                }
                i++;
                if(!linkedNotes.containsKey(tmpNote.toString())){
                    linkedNotes.put(tmpNote.toString(), notes.get(tmpNote.toString()));
                    numOfLinks++;
                }
                tmpNote = new StringBuilder();
            }
        }
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public dateClass getDate() {
        return date;
    }

    @Override
    public int getLinks() {
        return numOfLinks;
    }
}
