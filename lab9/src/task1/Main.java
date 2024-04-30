package task1;

public class Main {
    public static void main(String[] args) {
        SortedListSet<String> sortedSet = new SortedListSet<>();

        sortedSet.add("apple");
        sortedSet.add("banana");
        sortedSet.add("cherry");
        sortedSet.add("orange");
        sortedSet.add("watermelon");
        sortedSet.add("coconut");

        System.out.println("All elements in the set:");
        sortedSet.forEach(System.out::println);

        System.out.println("First element: " + sortedSet.first());
        System.out.println("Last element: " + sortedSet.last());

        System.out.println("Subset from 'banana' to 'orange':");
        SortedSet<String> subset = sortedSet.subSet("banana", "orange");
        subset.forEach(System.out::println);

        System.out.println("Head set up to 'orange':");
        SortedSet<String> headset = sortedSet.headSet("orange");
        headset.forEach(System.out::println);

        System.out.println("Tail set from 'orange':");
        SortedSet<String> tailset = sortedSet.tailSet("orange");
        tailset.forEach(System.out::println);
    }
}