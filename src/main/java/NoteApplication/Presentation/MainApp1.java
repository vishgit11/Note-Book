package NoteApplication.Presentation;

import NoteApplication.DAO.DAO;
import NoteApplication.DTO.Notes;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp1
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean status = true;
        do{
            System.out.println("Select below Option:\n" +
                    "1. Add Note\n" +
                    "2. Delete Note\n" +
                    "3. Update Note\n" +
                    "4. Display All Notes\n" +
                    "5. Exit");
            int opt = sc.nextInt();
            switch (opt){
                case 1:
                    addNote();
                    break;
                case 2:
                    deleteNote();
                    break;
                case 3:
                    updateNote();
                    break;
                case 4:
                    displayAllNote();
                    break;
                case 5:
                    status = false;
                    break;
                default:
                    System.out.println("Invalid Choice !!");
                    break;
            }
        }while (status);
    }

    private static void displayAllNote() {
        DAO d1 = new DAO();
        ArrayList<Notes> notes = d1.displayAllNotes();
        System.out.println("ID\t\tTITLE\t\tNOTE\t\tDATE");
        for (Notes n: notes)
        {
            System.out.println(n.getnId()+"\t\t"+n.getTitle()+"\t\t"+n.getNote()+"\t\t"+n.getDate());
        }
    }

    private static void updateNote() {
        DAO d1 = new DAO();
        System.out.println("Enter Note Id:");
        int nId = sc.nextInt();

        System.out.println("Enter Note Title:");
        String title = sc.next();

        System.out.println("Enter Note:");
        String note = sc.nextLine();
        note = sc.nextLine();

        Notes n1 = new Notes(nId, title, note);
        int count = d1.updateNote(n1);
        System.out.println(count+" rows updated successfully");
    }

    private static void deleteNote() {
        DAO d1 = new DAO();
        System.out.println("Enter Note Id to delete respective record");
        int nId = sc.nextInt();
        int count = d1.deleteNote(nId);
        System.out.println(count + " rows deleted successfully");
    }

    private static void addNote() {
        DAO d1 = new DAO();

        System.out.println("Enter Note ID:");
        int nId = sc.nextInt();

        System.out.println("Enter title:");
        String title = sc.next();


        System.out.println("Enter Note:");
        String note = sc.nextLine();
        note = sc.nextLine();

        Notes n1 = new Notes(nId, title, note);
        int count = d1.addNote(n1);
        System.out.println(count+ " rows updated successfully");
    }
}
