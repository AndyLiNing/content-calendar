package dev.ningli.content_calendar.JavaFoundations;

public class VarArgs {

    private static void varargsMethod(int... args) {
        for(Integer item : args) {
            System.out.println( "item: " + item);
        }
    }
}
