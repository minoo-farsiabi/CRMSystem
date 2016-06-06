import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by m.farsiabi on 6/5/2016.
 */
public class RegularCustomerDAO {
    private static RegularCustomerDAO ourInstance = new RegularCustomerDAO();

    public static RegularCustomerDAO getInstance() {
        return ourInstance;
    }


    private static final String driverDatabase = "com.mysql.cj.jdbc.Driver";
    private static final String connectionPrefix = "jdbc:mysql://localhost/myModels?";
    private static final String databaseUsername = "root";
    private static final String databasePassword = "minmin";

    private Connection connect = null;
    private Statement statement = null;

    private RegularCustomerDAO() {
    }
    public void initializeConnection() {
        try {
            Class.forName(driverDatabase);
            connect = DriverManager.getConnection(connectionPrefix + "user=" + databaseUsername + "&password=" + databasePassword + "&useSSL=false&serverTimezone=UTC");
            statement = connect.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<RegularCustomerModel> getAllCustomers() {
        ResultSet resultSet = null;

        try {
            if (connect == null || statement == null) {
                initializeConnection();
            }
            resultSet = statement.executeQuery("select * from myModels.regularcustomer");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return writeResultToList(resultSet);
    }

    private List<RegularCustomerModel> writeResultToList(ResultSet resultSet) {
        List<RegularCustomerModel> allCustomers = new ArrayList<RegularCustomerModel>();
        System.out.println("minooooo");
        try {
            while (resultSet.next()) {
                allCustomers.add(new RegularCustomerModel(new BigDecimal(resultSet.getString("customerNumber"))
                            ,resultSet.getString("firstname"), resultSet.getString("lastname"),
                            resultSet.getString("fathername"), resultSet.getString("dateOfBirth"),
                            new BigDecimal(resultSet.getString("nationalId"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCustomers;
    }
}
