package dev.ningli.content_calendar.JavaFoundations.ExecutiveFramework;

import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ExecutorServiceFoundation {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(2);
    private static final Consumer<String> printName = (String name) -> System.out.println("This is a name consumer: " + name);
    private static final Supplier<String> stringSupplier = () -> "This is a stringSupplier";
    private static final Runnable runnable = () -> System.out.println("This is a runnable.");
    private static final Callable<String> callable = () -> "This is a callable. ";


    public static void createExecutor() {

        try{
            executorService.submit(() -> System.out.println("Current thread name: " + Thread.currentThread().getName()));
            executorService.submit(callable);
        } finally {
            // Call shutdown to kill the thread when the task is done
            executorService.shutdown();
        }
        System.out.println("Outside thread name: " + Thread.currentThread().getName());
    }

    public static void completableFuture() {
        var executorService = Executors.newSingleThreadExecutor();
        var commonPool = ForkJoinPool.commonPool();
        // if no executor passing, the use the commonPool (common thread pool)
        CompletableFuture.runAsync(() -> System.out.println("completableFuture"), executorService);
    }

    public static void getFutureValue() {
        Future<String> res = executorService.submit(callable);
        try {
            // The get() of Future interface is blocking
            String value = res.get();
            System.out.println(value);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getCompletableFutureValue() {
        CompletableFuture.supplyAsync(() -> "username from DB")
                .thenAccept(System.out::println);
    }


    public static void HandleException() {
        CompletableFuture.supplyAsync(() -> "username from DB")
                .exceptionally(e -> "default value")
                .thenAccept(System.out::println);
    }


    public static void composeAsyncAction() {

    }





    public void longRunningProcess(Integer milliSeconds) throws InterruptedException {
        Thread.sleep(milliSeconds);
    }

    public CompletableFuture<String> supplyAsync() {
       return CompletableFuture.supplyAsync(stringSupplier);
    }

    public CompletableFuture<Void> runAsync () {
        return CompletableFuture.runAsync(runnable);
    }



}
