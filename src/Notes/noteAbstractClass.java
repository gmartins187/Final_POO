package Notes;
import App.*;

import java.util.HashMap;

public abstract class noteAbstractClass implements Note{

    private final dateClass date;
    private final String content;

    private final HashMap<String, Note> linkedNotes;

    public noteAbstractClass(dateClass date, String content) {
        this.date = date;
        this.content = content;
        linkedNotes = new HashMap<>();
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
    public int getLinks(HashMap<String, Note> notes) {
        int numOfLinks = 0;
        StringBuilder tmpNote;
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == '[') {
                numOfLinks++;
                i++;
                tmpNote = new StringBuilder();
                while (content.charAt(i) != ']') {
                    tmpNote.append(content.charAt(i));
                    i++;
                }
                if (!linkedNotes.containsKey(tmpNote.toString()))
                    linkedNotes.put(tmpNote.toString(), notes.get(tmpNote.toString()));
                else numOfLinks--;
            }
        }
        return numOfLinks;
    }
}
