package bonus;

import java.util.*;

class Node<T extends Comparable<T>> {
    private T value;
    private Node<T> right;
    private Node<T> left;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }
}

interface Tree<T extends Comparable<T>> {
    void addValue(T value);

    void addAll(List<T> values);

    HashSet<T> getValues(T inf, T sup);

    int size();

    boolean isEmpty();
}

class TreeImpl<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;
    private int size;

    @Override
    public void addValue(T value) {
        root = addRecursive(root, value);
        size++;
    }

    private Node<T> addRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(addRecursive(current.getLeft(), value));
        } else if (value.compareTo(current.getValue()) > 0) {
            current.setRight(addRecursive(current.getRight(), value));
        }

        return current;
    }

    @Override
    public void addAll(List<T> values) {
        for (T value : values) {
            addValue(value);
        }
    }

    @Override
    public HashSet<T> getValues(T inf, T sup) {
        HashSet<T> result = new HashSet<>();
        getValuesRecursive(root, inf, sup, result);
        return result;
    }

    private void getValuesRecursive(Node<T> node, T inf, T sup, HashSet<T> result) {
        if (node == null) {
            return;
        }

        if (inf.compareTo(node.getValue()) <= 0 && sup.compareTo(node.getValue()) >= 0) {
            result.add(node.getValue());
        }

        if (inf.compareTo(node.getValue()) < 0) {
            getValuesRecursive(node.getLeft(), inf, sup, result);
        }

        if (sup.compareTo(node.getValue()) > 0) {
            getValuesRecursive(node.getRight(), inf, sup, result);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

class Student implements Comparable<Student> {
    private final Float grade;

    public Student(Float grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Student student) {
        return this.grade.compareTo(student.grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "grade=" + grade +
                '}';
    }
}

public class Main {
    private static Integer testNr = 0;

    public static void main(String[] args) {

        final Tree<Student> tree = new TreeImpl<>();
        final List<Student> studentList = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            studentList.add(createGenericStudent((float) i));
        }

        printTestNr(); // 1
        System.out.println(tree.isEmpty());
        System.out.println(tree.size());
        System.out.println();

        printTestNr(); // 2
        for (int i = 0; i < 5; i++) {
            tree.addValue(createGenericStudent((float) i));
        }
        System.out.println(tree.size());
        System.out.println();

        printTestNr(); // 3
        tree.addAll(studentList);
        System.out.println(tree.isEmpty());
        System.out.println(tree.size());
        System.out.println();

        printTestNr(); // 4
        final Student studentThatPassedExam = new Student(5.0f);
        final Student studentThatWorkedHardToPassTheExam = new Student(10.0f);
        final HashSet<Student> values = tree.getValues(studentThatPassedExam, studentThatWorkedHardToPassTheExam);
        System.out.println(values.size());
        values.stream().sorted().forEach(System.out::println);
    }

    private static void printTestNr() {
        System.out.println("TEST " + ++testNr + " result:");
    }
    private static Student createGenericStudent(final Float grade) {
        return new Student(grade);
    }
}

