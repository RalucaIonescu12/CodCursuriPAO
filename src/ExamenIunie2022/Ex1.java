package ExamenIunie2022;

import java.util.LinkedHashSet;
import java.util.Set;

public class Ex1
{
    public static void main(String[] args) {
        Set s=new LinkedHashSet();
        s.add("1");
        s.add(1);
        s.add(3);
        s.add(2);
        s.stream().forEach(System.out::println);
        //1
        //1
        //3
        //2
    }

}

