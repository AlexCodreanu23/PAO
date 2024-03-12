package lab2.task1;


public class Dreptunghi extends Paralelogram {
    public Dreptunghi(int lat1, int lat2) {
        super(lat1,lat2, 0.00);
    }

    public Double arie(){
        return (double) latura1 * latura2;
    }
}
