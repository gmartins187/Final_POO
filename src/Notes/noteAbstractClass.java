package Notes;
import App.*;

public abstract class noteAbstractClass implements Note{

    private final dateClass date;
    private final String content;

    public noteAbstractClass(dateClass date, String content) {
        this.date = date;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public dateClass getDate() {
        return date;
    }
}
