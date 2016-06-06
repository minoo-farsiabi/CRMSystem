import java.util.List;

/**
 * Created by m.farsiabi on 6/5/2016.
 */
public class RegularCustomerController {
    private static RegularCustomerController ourInstance = new RegularCustomerController();

    public static RegularCustomerController getInstance() {
        return ourInstance;
    }

    private RegularCustomerController() {
        RegularCustomerDAO.getInstance().initializeConnection();
    }

    public List<RegularCustomerModel> getAllCustomers() {
        return RegularCustomerDAO.getInstance().getAllCustomers();
    }

    public void initializeConnection() {
        RegularCustomerDAO.getInstance().initializeConnection();
    }
}
