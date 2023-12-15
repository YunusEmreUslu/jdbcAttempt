import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        DbFunctions db=new DbFunctions();
        Connection conn=db.connect_to_db("tutdb","postgres","usluneinnein99");
       // db.createTable(conn, "employee");
        db.insert_row(conn, "employee", "Swag", "Turkmenistan");

    }
}