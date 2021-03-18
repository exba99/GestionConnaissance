package sn.bachir.domain;

public class DetailPrestation {
    private int id;
    private String details;
    private long prix;

    public DetailPrestation(int id, String details, long prix) {
        this.id = id;
        this.details = details;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public String getDetails() {
        return details;
    }

    public long getPrix() {
        return prix;
    }
}
