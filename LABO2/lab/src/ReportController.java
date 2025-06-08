
import java.util.List;


public class ReportController {
    private final ReportService service;
    private final StoreDao storeDao;
    private final ProduitDao produitDao;
    public ReportController(ReportService svc,StoreDao sd,ProduitDao pd)
    {
        this.service=svc;
        this.storeDao=sd;
        this.produitDao=pd;
    }
    public void printConsolidatedReport(){
        try{
            List<SaleReport> data=service.generateReport(storeDao,produitDao);
            System.out.println("--- Rapport consolidé (UC1) ---");
            data.forEach(r-> System.out.printf("%s | %s | %d%n",r.getStoreName(),r.getProductName(),r.getTotalQty()));
        }catch(Exception e){e.printStackTrace();}
    }

}
