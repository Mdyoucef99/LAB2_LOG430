import java.util.Scanner;
import java.sql.SQLException;
import java.util.List;



public class CaisseService implements Runnable {
    private final Store store;
    private final ProduitDao produitDao;
    private final StockDao stockDao;
    private final SaleDao saleDao;

    public CaisseService(Store store, ProduitDao produitDao, StockDao stockDao, SaleDao saleDao) {
        this.store = store;
        this.produitDao = produitDao;
        this.stockDao = stockDao;
        this.saleDao = saleDao;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--- CAISSE (" + store.getName() + ") ---");
            System.out.println("1. Rechercher produit");
            System.out.println("2. Enregistrer vente");
            System.out.println("3. Annuler vente");
            System.out.println("4. Consulter inventaire");
            System.out.println("0. Quitter");
            System.out.print("Choix: ");

            String input = sc.nextLine();
            try {
                switch (input) {
                    case "1":
                        System.out.print("Nom ou catégorie: ");
                        String keyword = sc.nextLine();
                        List<Produit> byName = produitDao.rechercherParNom(keyword);
                        byName.forEach(System.out::println);
                        List<Produit> byCat = produitDao.rechercherParCategorie(keyword);
                        byCat.forEach(System.out::println);
                        break;

                    case "2":
                        System.out.print("ID produit: ");
                        int idV = Integer.parseInt(sc.nextLine());
                        System.out.print("Quantité vendue: ");
                        int qV = Integer.parseInt(sc.nextLine());
                        produitDao.enregistrerVente(idV, qV);
                        Produit sold = produitDao.rechercherParId(idV);
                        stockDao.updateQuantity(store, sold, -qV);
                        saleDao.recordSale(store, sold, qV);
                        break;

                    case "3":
                        System.out.print("ID produit: ");
                        int idR = Integer.parseInt(sc.nextLine());
                        System.out.print("Quantité à retourner: ");
                        int qR = Integer.parseInt(sc.nextLine());
                        produitDao.annulerVente(idR, qR);
                        Produit returned = produitDao.rechercherParId(idR);
                        stockDao.updateQuantity(store, returned, qR);
                        break;

                    case "4":
                        List<Produit> inventaire = produitDao.getInventaire();
                        inventaire.forEach(System.out::println);
                        break;

                    case "0":
                        return;

                    default:
                        System.out.println("Choix invalide.");
                }
            } catch (SQLException e) {
                System.out.println("Erreur base de données: " + e.getMessage());
            }
        }
    }
}