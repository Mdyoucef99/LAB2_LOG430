import java.util.List;

public class DashboardController {
    private final DashboardService service;
    public DashboardController(DashboardService svc){this.service=svc;}
    public void showDashboard() {
        try { 
            List<SaleReport> stats=service.getSalesByStore(); 
            System.out.println("--- Tableau de bord (UC3) ---"); 
            for(SaleReport r:stats) System.out.printf("%s : %d ventes%n",r.getStoreName(),r.getTotalQty()); 
        } catch(Exception e){e.printStackTrace();}
    }
}
