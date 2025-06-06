import java.util.Scanner;

public class CaisseService implements Runnable {

    private final ProduitDao dao;

    public CaisseService(ProduitDao dao) {
        this.dao = dao;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("\n--- MENU CAISSE ---");
                System.out.println("1. Rechercher produit");
                System.out.println("2. Enregistrer vente");
                System.out.println("3. Annuler vente");
                System.out.println("4. Consulter stock");
                System.out.println("0. Quitter");

                System.out.print("Choix : ");
                int choix = sc.nextInt();
                sc.nextLine();

                switch (choix) {
                    case 1 -> {
                        System.out.print("Nom ou catégorie : ");
                        String s = sc.nextLine();
                        dao.rechercherParNom(s).forEach(System.out::println);
                        dao.rechercherParCategorie(s).forEach(System.out::println);
                    }
                    case 2 -> {
                        System.out.print("ID produit : ");
                        int id = sc.nextInt();
                        System.out.print("Quantité vendue : ");
                        int q = sc.nextInt();
                        dao.enregistrerVente(id, q);
                    }
                    case 3 -> {
                        System.out.print("ID produit : ");
                        int id = sc.nextInt();
                        System.out.print("Quantité à retourner : ");
                        int q = sc.nextInt();
                        dao.annulerVente(id, q);
                    }
                    case 4 -> dao.getInventaire().forEach(System.out::println);
                    case 0 -> System.exit(0);
                    default -> System.out.println("Choix invalide.");
                }

            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }
}