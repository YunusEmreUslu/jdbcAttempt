import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DbFunctions db = new DbFunctions();
        Connection conn = db.connect_to_db("tutdb", "postgres", "usluneinnein99");
        MenuHandler menuHandler = new MenuHandler();
        menuHandler.startMenuLoop(conn);
    }
}
