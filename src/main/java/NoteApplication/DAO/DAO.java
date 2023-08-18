package NoteApplication.DAO;

import NoteApplication.DTO.Notes;

import java.sql.*;
import java.util.ArrayList;

public class DAO {
    private static Connection con;

    {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1gga1?user=root&password=sql9867");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int addNote(Notes n1) {
        PreparedStatement pstmt = null;
        int count = 0;
        String quary = "insert into note_taker_info values(?, ?, ?, CURRENT_TIMESTAMP)";
        try {
            pstmt = con.prepareStatement(quary);
            pstmt.setInt(1, n1.getnId());
            pstmt.setString(2, n1.getTitle());
            pstmt.setString(3, n1.getNote());
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return count;
    }

    public int deleteNote(int nId) {
        Statement stmt = null;
        String quary = "delete from note_taker_info where nid="+nId;
        int count;
        try {
            stmt = con.createStatement();
            count = stmt.executeUpdate(quary);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public int updateNote(Notes n1) {
        PreparedStatement pstmt = null;
        String quary = "update note_taker_info set title = ?, date = CURRENT_TIMESTAMP, note = ? where nid = ?";
        int count;
        try {
            pstmt = con.prepareStatement(quary);
            pstmt.setString(1, n1.getTitle());
            pstmt.setString(2, n1.getNote());
            pstmt.setInt(3, n1.getnId());
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return count;
    }

    public ArrayList<Notes> displayAllNotes() {
        ArrayList<Notes> notes = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        String quary = "select * from note_taker_info";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(quary);
            while (rs.next()){
                Notes n1 = new Notes();
                n1.setnId(rs.getInt(1));
                n1.setTitle(rs.getString(2));
                n1.setNote(rs.getString(3));
                n1.setDate(rs.getDate(4));
                notes.add(n1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  notes;
    }
}
