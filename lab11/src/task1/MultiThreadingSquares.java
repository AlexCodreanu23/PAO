package task1;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;


public class MultiThreadingSquares {

    public static void main(String[] args) {
        System.out.println("Thread:");
        useThreads();

        System.out.println("\nParallelStream:");
        useParallelStream();

        System.out.println("\nCompletableFuture:");
        useCompletableFuture();
    }

    private static void useThreads() {
        int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        List<Integer> numbers = generateNumbers(10000);

        int chunkSize = numbers.size() / numberOfProcessors;
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numberOfProcessors; i++) {
            int start = i * chunkSize;
            int end = (i == numberOfProcessors - 1) ? numbers.size() : (i + 1) * chunkSize;

            Thread thread = new Thread(new SquareCalculator(numbers.subList(start, end)));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void useParallelStream() {
        List<Integer> numbers = IntStream.rangeClosed(1, 10000).boxed().collect(Collectors.toList());

        numbers.parallelStream().forEach(number -> {
            System.out.println(number + "^2=" + (number * number));
        });
    }

    private static void useCompletableFuture() {
        List<Integer> numbers = IntStream.rangeClosed(1, 10000).boxed().collect(Collectors.toList());

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (Integer number : numbers) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                System.out.println(number + "^2=" + (number * number));
            });
            futures.add(future);
        }

        futures.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    private static List<Integer> generateNumbers(int count) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(i + 1);
        }
        return numbers;
    }

    static class SquareCalculator implements Runnable {
        private List<Integer> numbers;

        public SquareCalculator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public void run() {
            for (Integer number : numbers) {
                System.out.println(number + "^2=" + (number * number));
            }
        }
    }
}
