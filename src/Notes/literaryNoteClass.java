package Notes;

import App.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class literaryNoteClass extends noteWithContentAbstractClass implements LiteraryNote{

    private LocalDate date;
    private final String workTitle;
    private final String authorName;
    private final LocalDate pubDate;
    private final String quote;
    private final String url;

    private int lastRoundDateUpdate;

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
    public literaryNoteClass(String id, String content, LocalDate date, Map<String, NoteWithContent> notes,
                             String workTitle, String authorName, LocalDate pubDate, String quote, String url) {
        super(id, content);
        this.date = date;
        this.workTitle = workTitle;
        this.authorName = authorName;
        this.pubDate = pubDate;
        this.quote = quote;
        this.url = url;
        computeLinks(notes, content);
        this.lastRoundDateUpdate = notesAppClass.getRoundNumber();
    }

    @Override
    public void setDate(LocalDate date) {
        this.date = date;
        lastRoundDateUpdate = notesAppClass.getRoundNumber();
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean isInThe(LocalDate startDate, LocalDate endDate) {
        return startDate.isBefore(this.date) && endDate.isAfter(this.date) ||
               startDate.isEqual(this.date) || endDate.isEqual(this.date);
    }

    @Override
    public int getUpdateRound() {
        return lastRoundDateUpdate;
    }
}
