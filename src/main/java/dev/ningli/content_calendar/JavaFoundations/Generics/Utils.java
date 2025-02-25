package dev.ningli.content_calendar.JavaFoundations.Generics;

import dev.ningli.content_calendar.JsonLoader.model.User;

import java.util.List;

public class Utils {

    // Extends

    // Input generic types
    // Before the return type of the method
    public static <T extends Comparable<T>> int getGreater(T a, T b) {
        return a.compareTo(b) > 0 ? 1 : 0;
    }

    public static <T extends Number> void read(List<T> users) {
        for(Number a : users) {
            System.out.println(a.byteValue());
        }
    }



    // Super
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        for (int i = 0; i <= src.size(); i++) {
            dest.set(i, src.get(i));
        }
    }


    static {
        var res = Utils.getGreater(2,4);
        System.out.println(Utils.class);
    }

}
