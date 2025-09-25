// Sem orientação a objetos
public class ProblemaPOO {
    public static void main(String[] args) {
        double xA = 3.0, xB = 4.0, xC = 5.0;
        double yA = 7.0, yB = 8.0, yC = 9.0;

        double areaX = (xA + xB + xC) / 2;
        double areaY = (yA + yB + yC) / 2;

        System.out.println("Área X: " + areaX);
        System.out.println("Área Y: " + areaY);
    }
}

// Com orientação a objetos
class Triangulo {
    double a, b, c;

    // Método para calcular área (reaproveitamento de código)
    public double area() {
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

class ProblemaComOO {
    public static void main(String[] args) {
        Triangulo t1 = new Triangulo();
        t1.a = 3.0; t1.b = 4.0; t1.c = 5.0;

        Triangulo t2 = new Triangulo();
        t2.a = 7.0; t2.b = 8.0; t2.c = 9.0;

        System.out.println("Área t1: " + t1.area());
        System.out.println("Área t2: " + t2.area());
    }
}
