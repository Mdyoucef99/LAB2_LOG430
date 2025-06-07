import java.sql.SQLException;
import java.util.List;

public class DashboardService {
 
    private final SaleDao saleDao;
    private final StoreDao storeDao;
    private final ProduitDao produitDao;

    public DashboardService(SaleDao saleDao, StoreDao storeDao, ProduitDao produitDao) {
        this.saleDao = saleDao;
        this.storeDao = storeDao;
        this.produitDao = produitDao;
    }

    /**
     * Retourne la liste des ventes agrégées par magasin.
     */
    public List<SaleReport> getSalesByStore() throws SQLException {
        // utilise les DAOs injectés pour construire le rapport
        return saleDao.consolidatedReport(storeDao, produitDao);
    }

}