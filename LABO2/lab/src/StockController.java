

public class StockController {
    private final StockService stockService;
    private final StoreDao storeDao;
    private final ProduitDao produitDao;

    public StockController(StockService stockService, StoreDao storeDao, ProduitDao produitDao) {
        this.stockService = stockService;
        this.storeDao = storeDao;
        this.produitDao = produitDao;
    }

    public void reorder(int prodId, int qty, int storeId) {
        try {
            Produit p = produitDao.rechercherParId(prodId);
            Store central = storeDao.findById(6);
            Store mag = storeDao.findById(storeId);
            stockService.reorder(central, mag, p, qty);
            System.out.println("Réapprovisionnement effectué.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}