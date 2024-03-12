package lab2.task1;


public class Romb extends Paralelogram {

    private double diag1;
    private double diag2;

    public Romb(double diag1, double diag2) {
        super(0, 0, 0.0);
        this.diag1 = diag1;
        this.diag2 = diag2;
    }

    public Double arie(){
        return (diag1 * diag2) / 2;
    }
}
