package dev.ningli.content_calendar.JavaFoundations;

public class VarArgs {

    private static void varargsMethod(String a, int ... args) {
        for(int item : args) {
            System.out.println( "item: " + item);
        }
    }
    static {
        VarArgs.varargsMethod("", 1,3,4,5);
    }

}
