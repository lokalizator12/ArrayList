package Main;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> array2 = new ArrayList<String>();
        ArrayList<Object> array3 = new ArrayList<>();
        ArrayList<Integer> array1 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            array1.add(i);
        }
        array2.add("q");
        array2.add("qw");
        array2.add("qwe");
        array2.add("qwer");
        array2.add("qwert");
        array2.add("qwerty");
        array2.add("qwertyu");
        array2.add("qwertyui");
        array2.add("qwertyuio");
        array2.add("qwertyuiop");
        System.out.println(array1.size());
        for (int x = 0; x < array1.size(); x++) {
            array3.add(array1.get(x) + " - " + array2.get(x));
            System.out.println(array3.get(x));
        }
    }
}
