package Files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Prelucrare_BMP {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fin = new FileInputStream("baboon.bmp");
        FileOutputStream fout = new FileOutputStream("complement_baboon.bmp");
        byte[] header = new byte[54];
        fin.read(header);
        fout.write(header);
        int octet;
        while ((octet = fin.read()) != -1) fout.write(255 - octet);
        fin.close();
        fout.close();
    }
}
