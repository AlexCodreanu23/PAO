package task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MultiThreadingWithTiming {

    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("timing_results.txt"))) {
            int[] sizes = {10, 1000, 10000, 10000000};

            for (int size : sizes) {
                List<Integer> numbers = generateNumbers(size);

                long startTime = System.currentTimeMillis();
                useSequential(numbers);
                long endTime = System.currentTimeMillis();
                writer.write("Sequential - Size " + size + ": " + (endTime - startTime) + "ms\n");

                startTime = System.currentTimeMillis();
                useThreads(numbers);
                endTime = System.currentTimeMillis();
                writer.write("Using Thread - Size " + size + ": " + (endTime - startTime) + "ms\n");

                startTime = System.currentTimeMillis();
                useParallelStream(numbers);
                endTime = System.currentTimeMillis();
                writer.write("Using parallelStream - Size " + size + ": " + (endTime - startTime) + "ms\n");

                startTime = System.currentTimeMillis();
                useCompletableFuture(numbers);
                endTime = System.currentTimeMillis();
                writer.write("Using CompletableFuture - Size " + size + ": " + (endTime - startTime) + "ms\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void useSequential(List<Integer> numbers) {
        for (Integer number : numbers) {
            System.out.println(number + "^2=" + (number * number));
        }
    }

    private static void useThreads(List<Integer> numbers) {
        int numberOfProcessors = Runtime.getRuntime().availableProcessors();
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

    private static void useParallelStream(List<Integer> numbers) {
        numbers.parallelStream().forEach(number -> {
            System.out.println(number + "^2=" + (number * number));
        });
    }

    private static void useCompletableFuture(List<Integer> numbers) {
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
        return IntStream.rangeClosed(1, count).boxed().collect(Collectors.toList());
    }

    static class SquareCalculator implements Runnable {
        private final List<Integer> numbers;

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


