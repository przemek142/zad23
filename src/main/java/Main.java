import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        BookDao bookDao = new BookDao();
        DbInit dbInit = new DbInit();
        dbInit.addBooks();

        Menu menu = new Menu();
        menu.menu(bookDao);
    }

}
