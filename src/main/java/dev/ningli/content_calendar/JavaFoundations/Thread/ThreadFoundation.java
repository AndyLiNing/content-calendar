package dev.ningli.content_calendar.JavaFoundations.Thread;

import java.lang.Thread;
public class ThreadFoundation {

    public static void printThread(){
        System.out.println("Thread activeCount: " + Thread.activeCount());
        System.out.println(Thread.currentThread().getName());
        System.out.println("Runtime availableProcessors: " + Runtime.getRuntime().availableProcessors());
    }

}
