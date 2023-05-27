package Serializare;

import java.io.Serializable;

public class Student implements Serializable {
    private static String facultate;
    private String nume;
    private int grupa, note[];
    private double medie;


    public Student(String ionPopescu, int grupa, int[] note) {
        this.nume = nume;
        this.grupa = grupa;
        this.note = note;
        this.medie = medie;
    }
}
