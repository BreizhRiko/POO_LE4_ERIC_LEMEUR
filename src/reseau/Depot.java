package reseau;

public class Depot extends Point{

    public Depot(int id, int x, int y) {
        super(id, x, y);
    }

    @Override
    public String toString() {
        return "Depot{"+
                "Point=" + super.toString() +
                "}";
    }

    public static void main(String[] arg){
        Depot d1 = new Depot(1,2,3);
        System.out.println(d1);
    }
}
