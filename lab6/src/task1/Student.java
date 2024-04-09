package task1;

public class Student {
    private String nume;
    private double notaLaborator;
    private double notaPartial;
    private double notaExamen;

    public Student(String nume, double notaLaborator, double notaPartial, double notaExamen) {
        this.nume = nume;
        this.notaLaborator = notaLaborator;
        this.notaPartial = notaPartial;
        this.notaExamen = notaExamen;
    }

    public double calculNotaTotala() {
        return notaLaborator + notaPartial + notaExamen;
    }

    public double calculMedie() {
        return (notaLaborator + notaPartial + notaExamen) / 3.0;
    }

    public String getNume() {
        return nume;
    }

    public double getNotaLaborator() {
        return notaLaborator;
    }

    public double getNotaPartial() {
        return notaPartial;
    }

    public double getNotaExamen() {
        return notaExamen;
    }
}
