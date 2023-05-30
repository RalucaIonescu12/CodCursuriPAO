package modelExamen2023;

import java.sql.*;
import java.util.Scanner;
/**
Se consideră baza de date Angajati, având următorul URL: jdbc:derby://localhost:1527/Angajati.
// Baza de date conține tabela DateAngajati, având câmpurile CNP, Nume, Varsta și Salariu.
// Scrieți un program care să citească de la tastatură o valoare reală s și valoare întreagă v,
// după care afișează informațiile despre angajații având cel mult v ani și salariul cel puțin s RON.
 */
public class Ex4Model {
    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7620469" , "sql7620469" , "ATZWkKKaN5");)
        {

            Scanner in = new Scanner(System.in);

            System.out.println("Salariul minim: ");
            float s = in.nextFloat();

            System.out.println("Varsta maxima: ");
            int v = in.nextInt();

            PreparedStatement pst = null;
            ResultSet rs = null;

            pst = conn.prepareStatement("SELECT * FROM angajati WHERE Salariu > ? AND Varsta < ?");
            pst.setFloat(1, s);
            pst.setInt(2, v);
            rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("Nume") + " " + rs.getFloat("Salariu") + " " + rs.getInt("Varsta"));
            }


        } catch (SQLException ex) {
            System.out.println("Eroare JDBC: " + ex);
        }


    }




//    int x = 0;
//    int[] a = {1, 2, 3, 4, 5};
//try{
//        a[1] = a[5] / (a[0]-1);
//    } catch (ArithmeticException e) {
//        System.out.print ("AE ");
//        x += 6;
//    } catch (IndexOutOfBoundsException e) { System.out.print ("IOBE ");
//        x += 5;
//    } catch (RuntimeException e) {
//        System.out.print ("RE ");
//        x+= 4;
//    } catch (Exception e) {
//        System.out.print ("E ");
//        x += 3;
//    } finally {
//        System.out.print ("F"); x += 2;
//        System.out.print(++x);
//    }
}

