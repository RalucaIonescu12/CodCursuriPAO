package Model2019;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Se consideră baza de date Diplome, având următorul URL: jdbc:derby://localhost:1527/Diplome.
 * Baza de date conține tabela DiplomeLicență, având câmpurile serie, absolvent, an, facultate,
 * specializare şi medie. Scrieți un program care să citească de la tastatură două valori întregi
 * an_min şi an_max, precum şi denumirea den_spec a unei specializări, după care creează o listă
 * cu informaţii despre diplomele eliberate între anii an_min şi an_max pentru specializarea den_spec.
 * Elementele listei vor fi obiecte de tipul clasei DiplomăLicență definită anterior (vom considera
 * faptul că aceasta implementează interfața Serializable). Dacă lista obţinută nu este vidă,
 * aceasta va fi serializată în fişierul diplome.dat, altfel se va afişa pe ecran un mesaj corespunzător.
 */
public class ExIV2019
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti anul minim: ");
        int anMin = scanner.nextInt();

        System.out.print("Introduceti anul maxim: ");
        int anMax = scanner.nextInt();

        System.out.print("Introduceti denumirea specializarii: ");
        String denSpec = scanner.next();

        List<DiplomaLicenta> listaDiplome = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Diplome");
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM DiplomeLicenta WHERE an >= ? AND an <= ? AND specializare = ?"
             )) {
            statement.setInt(1, anMin);
            statement.setInt(2, anMax);
            statement.setString(3, denSpec);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                String serie = resultSet.getString("serie");
                String absolvent = resultSet.getString("absolvent");
                int an = resultSet.getInt("an");
                String facultate = resultSet.getString("facultate");
                String specializare = resultSet.getString("specializare");
                double medie = resultSet.getDouble("medie");

                DiplomaLicenta diploma = new DiplomaLicenta(serie, absolvent, an, facultate, specializare, medie);
                listaDiplome.add(diploma);
            }

            if (!listaDiplome.isEmpty()) {
                try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("diplome.dat"))) {
                    outputStream.writeObject(listaDiplome);
                    System.out.println("Lista de diplome a fost serializata în fișierul diplome.dat.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Nu exista diplome pentru anii și specializarea specificate.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

