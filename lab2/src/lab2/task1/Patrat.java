package lab2.task1;

public class Patrat extends Dreptunghi {

    public Patrat(int latura) {
        super(latura,latura);
    }

    @Override
    public Double arie(){
        return (double)latura1 * latura1;
    }
}
