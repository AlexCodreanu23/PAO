package lab2.task1;

public class Paralelogram extends Patrulater {

    public Paralelogram(int latime, int lungime, double unghi) {
        super(latime, lungime, 0, 0, unghi, 0, 0, 0);
    }

    public Double arie(){
        return latura1 * latura2 * Math.sin(Math.toRadians(unghi1));
    }
}
