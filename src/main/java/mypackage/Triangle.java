package mypackage;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;
    private double ab;
    private double bc;
    private double ca;

    public Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
        this.ab = calculateDistance(a,b);
        this.bc = calculateDistance(b,c);
        this.ca = calculateDistance(c,a);
    }

    public double calcArea(){
        double p =(ab + bc + ca) / 2;
        return Math.sqrt(p * (p - ab) * (p - bc) * (p - ca));
    }

    private double calculateDistance(Point p1, Point p2){
        double a = Math.pow((p1.getX()-p2.getX()),2);
        double b = Math.pow((p1.getY()-p2.getY()),2);
        return Math.sqrt(a+b);
    }

    public boolean isIsoscelesTriangle(){
        boolean isIsosceles = false;
        if ((ab == bc) || (bc == ca) || (ca == ab)){
            isIsosceles = true;
        }
        return isIsosceles;
    }
    public  boolean isGreaterThan(Triangle o){
        return calcArea() > o.calcArea();
    }

    @Override
    public String toString(){
        return ""+ a + b + c;
    }
}
