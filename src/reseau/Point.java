package reseau;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class Point {
    private final int id;
    private int abscisse;
    private int ordonnee;

    private Map<Point,Route> routes;

    public int getId() {
        return id;
    }

    public int getAbscisse() {
        return abscisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    public Point(int id,int x, int y) {
        this.id = id;
        this.ordonnee=x;
        this.abscisse=y;
        this.routes = new HashMap<>();
    }

    /**
     *
     * @param arrive
     * ajoute une route a notre HashMap de routes
     */
    public void ajouterRoute(Point arrive){
        Route route = new Route(this,arrive);
        this.routes.put(arrive,route);
    }

    /**
     *
     * @param arrive
     * @return infinie si la route est null, ou le cout de la route vers le point arrive
     *
     */
    public int getCoutVers(Point arrive){
        Route route = this.routes.get(arrive);
        if (route == null){
            return Integer.MAX_VALUE;
        }
        return route.getCout();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point point)) return false;
        return getId() == point.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", abscisse=" + abscisse +
                ", ordonnee=" + ordonnee +
                '}';
    }

    public static void main(String[] args) {
        Depot d1 = new Depot(1,20,30);
        Depot d2 = new Depot(1,2,3);
        System.out.println(d1.getCoutVers(d2));
        d1.ajouterRoute(d2);
        System.out.println(d1.getCoutVers(d2));
    }
}

