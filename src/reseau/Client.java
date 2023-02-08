package reseau;

public class Client extends Point{

    private int demande;

    public Client(int id, int x, int y, int demande) {
        super(id, x, y);
        this.demande = demande;
    }

    public int getDemande() {
        return demande;
    }

    @Override
    public String toString() {
        return "Client{" +
                "demande=" + demande +
                super.toString() +
                '}';
    }

    public static void main(String[] args) {
        Client c1 = new Client(1,2,3,0);
        Client c2 = new Client(1,1,4,0);
        System.out.println(c1);
        System.out.println(c2);

    }

}
