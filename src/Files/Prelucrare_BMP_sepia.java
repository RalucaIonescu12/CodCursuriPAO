package Files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Prelucrare_BMP_sepia {
//        următoarea aplicație Java, vom utiliza un fișier cu acces aleatoriu
//        pentru a afișa dimensiunea imaginii în octeți și în pixeli, după care
//        vom transforma imaginea color inițială într-una sepia, ținând cont de faptul
//        că fișierele BMP sunt implicit de tip little-endian:

    public static void main(String[] args) throws FileNotFoundException,
            IOException {
//deschidem fișierul în mod mixt, deoarece trebuie să efectuăm și
//operații de citire și operații de scriere
        RandomAccessFile img = new RandomAccessFile("baboon.bmp", "rw");
//citim din fișier dimensiunea imaginii în octeți și o afișam
        byte[] b = new byte[4];
        ByteBuffer aux = ByteBuffer.allocate(4);
        img.seek(2);
        img.read(b);
        aux.put(b);
        aux.order(ByteOrder.LITTLE_ENDIAN);
        int imgBytes = aux.getInt(0);
        System.out.println("Dimensiunea imaginii: " + imgBytes + " bytes");
//citim din fișier dimensiunea imaginii în pixeli și o afișam
        img.seek(18);
        int imgWidth = img.readInt();
        imgWidth = Integer.reverseBytes(imgWidth);
        int imgHeight = img.readInt();
        imgHeight = Integer.reverseBytes(imgHeight);
        System.out.println("Dimensiunea imaginii: " + imgWidth + " x " +
                imgHeight + " pixeli");
//calculăm padding-ul imaginii și îl afișăm
        int imgPadding;
        if (imgWidth % 4 != 0)
            imgPadding = 4 - (3 * imgWidth) % 4;
        else
            imgPadding = 0;
        System.out.println("Padding-ul imaginii: " + imgPadding + " bytes");
//modificăm imaginea color într-una sepia
//în tabloul de octeți pixelRGB citim valorile pixelului curent color
        byte[] pixelRGB = new byte[3];
//        în tabloul de octeți auxRGB vom calcula noile valori ale pixelului
//curent transformat în sepia, folosind formulele de mai sus și ținând
//cont de faptul că în fișier canalele de culoare sunt în ordinea BGR
        byte[] auxRGB = new byte[3];
        double tmp = 0;
//mutăm cursorul la începutul zonei de date, imediat după header-ul
//de 54 de octeți
        img.seek(54);
        for (int h = 0; h < imgHeight; h++) {
            for (int w = 0; w < imgWidth; w++) {
//citim valorile RGB ale pixelului curent în ordinea BGR
                img.read(pixelRGB);
//calculăm valorile sepia ale pixelului curent
                tmp = 0.272 * Byte.toUnsignedInt(pixelRGB[2]) +
                        0.534 * Byte.toUnsignedInt(pixelRGB[1]) +
                        0.131 * Byte.toUnsignedInt(pixelRGB[0]);
                auxRGB[0] = (byte) (tmp <= 255 ? tmp : 255);
                tmp = 0.349 * Byte.toUnsignedInt(pixelRGB[2]) +
                        0.686 * Byte.toUnsignedInt(pixelRGB[1]) +
                        0.168 * Byte.toUnsignedInt(pixelRGB[0]);
                auxRGB[1] = (byte) (tmp <= 255 ? tmp : 255);
                tmp = 0.393 * Byte.toUnsignedInt(pixelRGB[2]) +
                        0.769 * Byte.toUnsignedInt(pixelRGB[1]) +
                        0.189 * Byte.toUnsignedInt(pixelRGB[0]);
                auxRGB[2] = (byte) (tmp <= 255 ? tmp : 255);
//ne întoarcem 3 octeți în fișier pentru a suprascrie valorile
//color ale pixelului curent cu cele sepia calculate mai sus
                img.seek(img.getFilePointer() - 3);
                img.write(auxRGB);
            }
//după ce am prelucrat toți pixelii de pe o linie, sărim peste
//pixelii de padding
            img.skipBytes(imgPadding);
        }
        img.close();
    }
}
