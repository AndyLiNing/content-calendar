package dev.ningli.content_calendar.Utils;

public class VarArgs {

    private static void varargsMethod(int... args) {
        for(Integer item : args) {
            System.out.println( "item: " + item);
        }
    }
}
