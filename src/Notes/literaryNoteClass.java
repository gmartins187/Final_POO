package Notes;
import App.*;

import java.util.HashMap;

public class literaryNoteClass extends noteAbstractClass implements LiteraryNote{

    private final String workTitle;
    private final String authorName;
    private final dateClass pubDate;
    private final String quote;
    private final String url;

    /**
     * Constructor for the literaryNoteClass. Creates a new literary note.
     * @param content the content of the note
     * @param date the date of the note
     * @param notes the notes of the note
     * @param workTitle the title of the work
     * @param authorName the name of the author
     * @param pubDate the publication date of the work
     * @param quote the quote from the work
     * @param url the url of the work
     */
    public literaryNoteClass(String content, dateClass date, HashMap<String, Note> notes, String workTitle, String authorName, dateClass pubDate, String quote, String url) {
        super(date, content, notes);
        this.workTitle = workTitle;
        this.authorName = authorName;
        this.pubDate = pubDate;
        this.quote = quote;
        this.url = url;
    }
}
