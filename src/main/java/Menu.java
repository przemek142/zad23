import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void menu(BookDao bookDao) throws SQLException {
        String sc = "";

        while (!"exit".equals(sc)) {
            System.out.println("1. pokaż wszystkie\n" +
                    "2. usuń po ID\n" +
                    "3. wyszukaj\n" +
                    "4. dodaj\n" +
                    "5. exit");
            sc = scanner.nextLine();

            switch (sc) {
                case "1":
                    System.out.println(bookDao.readAll().toString());
                    break;
                case "2":
                    System.out.println("id do skasowania:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    bookDao.del(id);
                    System.out.println("skasowano: " + id + "\n");
                    break;
                case "3":
                    System.out.println("podaj szukany tekst:");
                    String txt = scanner.nextLine();
                    System.out.println(bookDao.readByAuthorOrTitle(txt).toString());
                    break;
                case "4":
                    System.out.println("podaj tytuł,autora i ISBN po przecinku: ");
                    String[] data = scanner.nextLine().split(",");
                    bookDao.save(new Book(data[0].trim(),data[1].trim(),data[2].trim()));
                    break;
                case "5":
                    sc = "exit";
            }

        }
    }
}