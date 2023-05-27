package Externalizare;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Student implements Externalizable {
    public static String facultate;
    String nume;
    int grupa, note[];
    double medie;
    static {
        facultate="FMI";
    }

    public Student() {
        this.nume = "nume";
        this.grupa = 10;
        this.note = new int[]{10, 9, 8};
        this.medie = (double)(10+9+8)/3;
    }
//se va salva denumirea facultății (prin serializare nu ar fi fost salvată,
//deoarece este o dată membră statică)
//nu se vor salva notele unui student
//media va fi "criptată" folosind formula 2*medie+3
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(facultate);
        out.writeUTF(nume);
        out.writeInt(grupa);
        out.writeDouble(2 * medie + 3);
        out.writeObject(note);
    }

    //media va fi "decriptată" folosind formula inversă (medie-3)/2
    @Override
    public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException
    {
        facultate = in.readUTF();
        nume = in.readUTF();
        grupa = in.readInt();
        medie = in.readDouble();
        medie = (medie - 3) / 2;
    }
}
