import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        DbFunctions db=new DbFunctions();
        Connection conn=db.connect_to_db("tutdb","postgres","usluneinnein99");
       // db.createTable(conn, "employee");
       // db.insert_row(conn, "employee", "Yolo", "Turkistan");
       // db.update_name(conn,"employee","Swag", "Suleyman");
       // db.read_data(conn,"employee");
       // db.search_by_name(conn, "employee", "Suleyman");
       // db.search_by_id(conn, "employee", 2);
       // db.delete_row_by_name(conn, "employee", "Yolo");
       // db.delete_row_by_id(conn, "employee", 3 );
       // db.read_data(conn, "employee");
       // db.delete_table(conn, "employee");
    }
}