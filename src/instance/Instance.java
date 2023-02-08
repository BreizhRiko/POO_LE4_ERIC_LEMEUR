package instance;

import instance.reseau.Client;
import instance.reseau.Depot;
import io.InstanceReader;
import io.exception.ReaderException;

import java.util.*;

public class Instance {
    private String nom;
    private int capacite;
    private Depot depot;

    private Map<Integer, Client> assoClient;

    public Instance(String nom, int capacite, Depot depot) {
        this.nom = nom;
        this.capacite = capacite;
        this.depot = depot;
        this.assoClient = new LinkedHashMap<>();
    }

    public int getNbClients(){
        return this.assoClient.size();
    }

    public Client getClientById(int id){
        return this.assoClient.get(id);
    }

    public LinkedList<Client> getClients(){
        return new LinkedList<Client>(this.assoClient.values());
    }

    public boolean ajouterClient(Client clientToAdd){
        if (clientToAdd == null){return false;}
        for (Map.Entry clientEntry : this.assoClient.entrySet() ) {
            Client client = (Client) clientEntry.getValue();
            clientToAdd.ajouterRoute(client);
            client.ajouterRoute(clientToAdd);
        }
        clientToAdd.ajouterRoute(depot);
        this.depot.ajouterRoute(clientToAdd);
        this.assoClient.put(clientToAdd.getId(),clientToAdd);
        return true;
    }

//region get set
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }
//endregion
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instance instance)) return false;
        return getCapacite() == instance.getCapacite() && getNom().equals(instance.getNom()) && getDepot().equals(instance.getDepot());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getCapacite(), getDepot());
    }

    @Override
    public String toString() {
        return "Instance{" +
                "nom='" + nom + '\'' +
                ", capacite=" + capacite +
                ", depot=" + depot +
                ", clients" + assoClient +
                '}';
    }

    public static void main(String[] args) {
        try {
            InstanceReader reader = new InstanceReader("instances/A-n32-k5.vrp");
            reader.readInstance();
            System.out.println(reader.readInstance().toString());
        } catch (ReaderException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
