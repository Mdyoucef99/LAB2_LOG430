
import java.util.Date;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "sales")
public class Sale {
    
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(foreign = true, columnName = "store_id", canBeNull = false)
    private Store store;

    @DatabaseField(foreign = true, columnName = "product_id", canBeNull = false)
    private Produit produit;

    @DatabaseField(canBeNull = false)
    private int quantity;

    @DatabaseField(canBeNull = false)
    private Date saleDate;

    public Sale() { }

    public Sale(Store store, Produit produit, int quantity) {
        this.store = store;
        this.produit = produit;
        this.quantity = quantity;
        this.saleDate = new Date();
    }

    public Store getStore() { return store; }
    public Produit getProduit() { return produit; }
    public int getQuantity() { return quantity; }
    public Date getSaleDate() { return saleDate; }
}

