package dev.ningli.content_calendar.JavaFoundations.ExecutiveFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ExecutorServiceFoundation {

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    Consumer<String> printName = (String name) -> System.out.println("User name: " + name);
    Supplier<String> getName = () -> "Andy";


    public void longRunningProcess() {

    }



}
