import java.sql.SQLException;
import java.util.List;

public class ReportService {
    private final SaleDao saleDao;

    public ReportService(SaleDao saleDao) {
        this.saleDao = saleDao;
    }
    public List<SaleReport> generateReport(StoreDao sd, ProduitDao pd) throws SQLException {
        return saleDao.consolidatedReport(sd, pd);
    }

    
}