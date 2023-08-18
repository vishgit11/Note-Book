package NoteApplication.DTO;

import java.sql.Date;

public class Notes {
    private int nId;
    private String title;
    private  String note;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Notes() {
    }

    public Notes(int nId, String title, String note) {
        this.nId = nId;
        this.title = title;
        this.note = note;
    }

    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
