package Controller;


import java.sql.SQLException;
import java.util.List;

import dao.*;
import Model.Sale;
import Model.Stock;
import Model.Store;


public class DashboardController {

    private final StoreDao   storeDao;
    private final ProduitDao produitDao;
    private final StockDao   stockDao;
    private final SaleDao    saleDao;

    public DashboardController(StoreDao storeDao,
                               ProduitDao produitDao,
                               StockDao stockDao,
                               SaleDao saleDao) {
        this.storeDao   = storeDao;
        this.produitDao = produitDao;
        this.stockDao   = stockDao;
        this.saleDao    = saleDao;
    }

    public void showDashboard() {
        try {
            List<Store>    stores   = storeDao.listAll();
            System.out.println("\n=== Tableau de bord (UC3) ===");

            // 1) Chiffre d’affaires par magasin
            System.out.println("\n-- Chiffre d'affaires par magasin --");
            for (Store s : stores) {
                double revenue = 0;

                List<Sale> sales = saleDao.getDao().queryForEq("store_id", s.getId());

               for (Sale sale : sales) {
                    revenue += sale.getQuantity() * sale.getProduit().getPrix();
                }

                 System.out.printf("%s : %.2f $%n", s.getName(), revenue);
            }

            // 2) Alertes de rupture de stock
            System.out.println("\n-- Alertes de rupture de stock --");
            for (Store s : stores) {

                boolean empty = false;
                System.out.printf("%s :", s.getName());
                List<Stock> stocks = stockDao.listByStore(s);

                for (Stock st : stocks) {

                    if (st.getQuantity() == 0) {
                        System.out.print(" " + st.getProduit().getNom());
                        empty =true;
                    }
                }
                if (!empty) {
                     System.out.print(" aucune");
                    }

                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("Erreur UC3: " + e.getMessage());
        }
    }

}
