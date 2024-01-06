import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class MenuHandler {
    private Scanner scanner;
    private DbFunctions db;

    public MenuHandler() {
        scanner = new Scanner(System.in);
        db = new DbFunctions();
    }

    public void startMenuLoop(Connection conn) {
        boolean exitProgram = false;
        List<String> existingTables = db.getListOfTables(conn);
        while (!exitProgram) {

            System.out.println("Main Menu:");
            System.out.println("1. Create Table");
            System.out.println("2. Insert Row");
            System.out.println("3. Read Data");
            System.out.println("4. Update Name");
            System.out.println("5. Search by Name");
            System.out.println("6. Search by ID");
            System.out.println("7. Delete Row by Name");
            System.out.println("8. Delete Row by ID");
            System.out.println("9. Delete Table");
            System.out.println("10. Exit");

            System.out.print("Enter your choice (1-10): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("You selected create table");
                    System.out.print("Enter table name: ");
                    String tableName0 = scanner.nextLine();

                    db.createTable(conn, tableName0);
                    System.out.println("Returning to menu");
                    break;

                case 2:
                    System.out.println("You selected insert row");

                    // Get the list of existing tables to validate user input


                    System.out.print("Enter table name: ");
                    String insertRowTableName = scanner.nextLine();

                    if (existingTables.contains(insertRowTableName)) {
                        System.out.print("Enter employee name: ");
                        String insertRowEmployeeName = scanner.nextLine();

                        System.out.print("Enter employee address: ");
                        String insertRowEmployeeAddress = scanner.nextLine();

                        db.insert_row(conn, insertRowTableName, insertRowEmployeeName, insertRowEmployeeAddress);
                    } else {
                        System.out.println("Table '" + insertRowTableName + "' does not exist.");
                    }
                    break;
                case 3:
                    System.out.println("You selected read data");
                    System.out.print("Enter table to read data from: ");
                    String readDataTableName = scanner.nextLine();

                    if (existingTables.contains(readDataTableName)) {
                        db.read_data(conn, readDataTableName);
                    } else {
                        System.out.println("Table '" + readDataTableName + "' does not exist.");
                    }
                    break;
                case 4:
                    System.out.println("You selected update name");
                    System.out.print("Enter table name: ");
                    String updateNameTableName = scanner.nextLine();

                    if (existingTables.contains(updateNameTableName)) {
                        System.out.print("Enter employee old name: ");
                        String updateNameOldEmployeeName = scanner.nextLine();

                        System.out.print("Enter employee new name: ");
                        String updateNameNewEmployeeName = scanner.nextLine();
                        db.update_name(conn, updateNameTableName, updateNameOldEmployeeName, updateNameNewEmployeeName);
                    } else {
                        System.out.println("Table '" + updateNameTableName + "' does not exist.");
                    }
                    break;
                case 5:
                    System.out.println("You selected search by name");
                    System.out.print("Enter table name: ");
                    String searchByNameTableName = scanner.nextLine();

                    if (existingTables.contains(searchByNameTableName)) {
                        System.out.print("Enter name to search: ");
                        String searchByName = scanner.nextLine();
                        db.search_by_name(conn, searchByNameTableName, searchByName);
                    } else {
                        System.out.println("Table '" + searchByNameTableName + "' does not exist.");
                    }
                    break;

                case 6:
                    System.out.println("You selected search by id");
                    System.out.print("Enter table name: ");
                    String searchByIDTableName = scanner.nextLine();

                    if (existingTables.contains(searchByIDTableName)) {
                        System.out.print("Enter ID to search: ");
                        String searchByID = scanner.nextLine();
                        db.search_by_id(conn, searchByIDTableName, Integer.parseInt(searchByID));
                    } else {
                        System.out.println("Table '" + searchByIDTableName + "' does not exist.");
                    }
                    break;

                case 7:
                    System.out.println("You selected delete row by name");
                    System.out.print("Enter table name: ");
                    String deleteRowByNameTableName = scanner.nextLine();

                    if (existingTables.contains(deleteRowByNameTableName)) {
                        System.out.print("Enter name of row to delete: ");
                        String deleteRowByName = scanner.nextLine();
                        db.delete_row_by_name(conn, deleteRowByNameTableName, deleteRowByName);
                    } else {
                        System.out.println("Table '" + deleteRowByNameTableName + "' does not exist.");
                    }
                    break;

                case 8:
                    System.out.println("You selected delete row by id");
                    System.out.print("Enter table name: ");
                    String deleteByIDTableName = scanner.nextLine();

                    if (existingTables.contains(deleteByIDTableName)) {
                        System.out.print("Enter ID of row to delete: ");
                        String deleteByID = scanner.nextLine();
                        db.delete_row_by_id(conn, deleteByIDTableName, Integer.parseInt(deleteByID));
                    } else {
                        System.out.println("Table '" + deleteByIDTableName + "' does not exist.");
                    }
                    break;

                case 9:
                    System.out.println("You selected delete table");
                    System.out.print("Enter table name to delete: ");
                    String deleteTableName = scanner.nextLine();

                    if (existingTables.contains(deleteTableName)) {
                        db.delete_table(conn, deleteTableName);
                    } else {
                        System.out.println("Table '" + deleteTableName + "' does not exist.");
                    }
                    break;
                case 10:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 10.");
            }
        }

        System.out.println("Exiting the program. Goodbye!");
        scanner.close();
    }

    private void printMainMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. Create Table");
        System.out.println("2. Insert Row");
        System.out.println("3. Read Data");
        // ... (other menu options)
        System.out.println("10. Exit");

        System.out.print("Enter your choice (1-10): ");
    }

    private void handleCreateTable(Connection conn) {
        System.out.println("You selected create table");
        System.out.print("Enter table name: ");
        String tableName = scanner.nextLine();
        db.createTable(conn, tableName);
        System.out.println("Returning to menu");
    }

    private void handleInsertRow(Connection conn) {
        // Similar logic as in your existing code for inserting a row
    }

    private void handleReadData(Connection conn) {
        // Similar logic as in your existing code for reading data
    }

    // Add similar private methods for other menu options
}
