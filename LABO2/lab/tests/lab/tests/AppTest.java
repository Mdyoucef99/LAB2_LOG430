package lab.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import Model.Produit;
import Model.Sale;
import Model.Stock;
import Model.Store;

public class AppTest {

 /*   @Test
    public void ProduitConstructeurEtGetters() {
        Produit p = new Produit(42, "Chocolat", "Alimentaire", 3.5, 10);
        assertEquals(42, p.getId());
        assertEquals("Chocolat", p.getNom());
        assertEquals("Alimentaire", p.getCategorie());
        assertEquals(3.5, p.getPrix(), 0.0001);
        assertEquals(10, p.getQuantite());
    }

    @Test
    public void StockConstructeurEtGetters() {
        Store s = new Store("S1");
        Produit p = new Produit(5, "Savon", "Hygiène", 1.2, 20);
        Stock stock = new Stock(s, p, 15);

        assertEquals(s, stock.getStore());
        assertEquals(p, stock.getProduit());
        assertEquals(15, stock.getQuantity());
    }


    @Test
    public void SaleConstructeurEtGetters() {
        Store s = new Store("M1");
        Produit p = new Produit(7, "Lait", "Boisson", 1.8, 50);
        Sale sale = new Sale(s, p, 4);

        assertEquals(s, sale.getStore());
        assertEquals(p, sale.getProduit());
        assertEquals(4, sale.getQuantity());
        assertNotNull(sale.getSaleDate());
    }

    */ 

        @Test
    public void test1() {
        int a = 0;
        int b = 1;
        int c = a + b;
        assertEquals(1, c);
    }


}
