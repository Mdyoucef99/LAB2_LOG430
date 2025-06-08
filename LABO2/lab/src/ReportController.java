
import java.util.List;


public class ReportController {
    private final ReportService service;
    private final StoreDao storeDao;
    private final ProduitDao produitDao;
    private final StockDao stockDao;


    public ReportController(ReportService service, StoreDao storeDao,ProduitDao produitDao, StockDao stockDao) {
        this.service     = service;
        this.storeDao    = storeDao;
        this.produitDao  = produitDao;
        this.stockDao    = stockDao;
    }

    public void printConsolidatedReport(){
        try{
            // 1) Détail des ventes par magasin et produit
            List<SaleReport> sales = service.generateReport(storeDao, produitDao);
            System.out.println("\n=== Ventes détaillées par magasin ===");
            sales.forEach(r ->
                System.out.printf("%s | %s | Qté vendue : %d%n",
                                  r.getStoreName(),
                                  r.getProductName(),
                                  r.getTotalQty())
            );


            System.out.println("\n=== Stocks restants par magasin ===");
            for (Store s : storeDao.listAll()) {
                System.out.printf("Magasin %s :%n", s.getName());
                List<Stock> stocks = stockDao.listByStore(s);
                for (Stock st : stocks) {
                    System.out.printf("  %s : %d en stock%n",
                                      st.getProduit().getNom(),
                                      st.getQuantity());
                }
            }

        }catch(Exception e){e.printStackTrace();}
    }

}
