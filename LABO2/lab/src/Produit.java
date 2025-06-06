import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "produits")
public class Produit {

    @DatabaseField(id = true)
    private int id;

    @DatabaseField
    private String nom;

    @DatabaseField
    private String categorie;

    @DatabaseField
    private double prix;

    @DatabaseField
    private int quantite;

    public Produit() {// Constructeur requis par ORMLite  
        }

    public Produit(int id, String nom, String categorie, double prix, int quantite) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.quantite = quantite;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getCategorie() { return categorie; }
    public double getPrix() { return prix; }
    public int getQuantite() { return quantite; }

    
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return id + " - " + nom + " (" + categorie + ") : " + prix + " $ [" + quantite + " en stock]";
    }
}
