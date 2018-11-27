import java.sql.*;

public class BookDao {
    private static final String URL = "jdbc:mysql://192.168.56.101/library?characterEncoding=utf8&serverTimezone=UTC";
    private final String USERNAME = "root";
    private final String PASSWORD = "orion12";
    private Connection connection;

    public BookDao() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void save(Book book) throws SQLException {
        final String insert = "insert into library(title, author, ISBN) values (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(insert);
        statement.setString(1, book.getTitle());
        statement.setString(2, book.getAuthor());
        statement.setInt(3, book.getISBN());
        statement.executeUpdate();
    }

    public Book read(int id) throws SQLException {
        final String read = "select * from library where id=?";
        PreparedStatement statement = connection.prepareStatement(read);
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        Book result =null;
        if (resultSet.next()){
            result =new Book();
            result.setId(resultSet.getInt("ID"));
            result.setTitle(resultSet.getString("title"));
            result.setAuthor(resultSet.getString("author"));
            result.setISBN(resultSet.getInt("ISBN"));
        }
        return  result;

    }
}


//    CREATE TABLE `library`.`library` (
//        `ID` INT NOT NULL AUTO_INCREMENT,
//        `title` VARCHAR(60) NOT NULL,
//        `author` VARCHAR(120) NOT NULL,
//        `ISBN` INT(13) NOT NULL,
//        PRIMARY KEY (`ID`),
//        UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
//        UNIQUE INDEX `ISBN_UNIQUE` (`ISBN` ASC) VISIBLE);
