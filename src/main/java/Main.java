import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Book book = new Book("a","b",3);

        BookDao employeeDao = new BookDao();
        employeeDao.save(book);

        System.out.println(employeeDao.read(1));

    }

}
