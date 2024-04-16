package task4;

import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        IntStream.rangeClosed(2, 10)
                .filter(num -> num % 2 == 0)
                .mapToObj(num -> new Pair(num, num * num))
                .forEach(System.out::println);
    }
    static class Pair {
        int number;
        int square;

        public Pair(int number, int square) {
            this.number = number;
            this.square = square;
        }

        @Override
        public String toString() {
            return "Number: " + number + ", Square: " + square;
        }
    }
}