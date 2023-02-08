package instance.reseau;

import java.util.Objects;

public class Route {

    private int cout;
    private Point depart;
    private Point arrive;

    public Route(Point depart, Point arrive) {
        this.depart = depart;
        this.arrive = arrive;
        this.cout = CalculeCout(depart,arrive);
    }

    public int getCout() {
        return cout;
    }

    public Point getDepart() {
        return depart;
    }

    public Point getArrive() {
        return arrive;
    }

    private int CalculeCout(Point p1, Point p2){
        return Math.toIntExact(Math.round(Math.sqrt(Math.pow(p2.getAbscisse() - p1.getAbscisse(), 2) +
                Math.pow(p2.getOrdonnee() - p1.getOrdonnee(), 2))));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Route route)) return false;
        return depart.equals(route.depart) && arrive.equals(route.arrive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depart, arrive);
    }

    @Override
    public String toString() {
        return "Route{" +
                "cout=" + cout +
                ", depart=" + depart +
                ", arrive=" + arrive +
                '}';
    }

    public static void main(String[] args) {
        Client c1 = new Client(1,2,3,0);
        Depot d1 = new Depot(1,20,30);

        Route r1 = new Route(c1,d1);

        System.out.println(r1);
    }
}
