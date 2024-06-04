package task5;

public class Bilants implements Comparable<Bilants>{
    private int pozitive;
    private int negative;

    public Bilants(){
        pozitive = 0;
        negative = 0;
    }

    public Bilants(int pozitive, int negative){
        this.pozitive = pozitive;
        this.negative = negative;
    }

    public int compareTo(Bilants b){
        int diff = pozitive - negative;
        int diff2 = b.pozitive - b.negative;
        return Integer.compare(diff2,diff);
    }

    public String toString(){
        return "Bilants[ pozitive: "+ pozitive + " negative: " + negative + "]";
    }



}
