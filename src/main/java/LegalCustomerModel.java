import java.math.BigDecimal;

/**
 * Created by m.farsiabi on 6/5/2016.
 */
public class LegalCustomerModel {
    private BigDecimal customerNumber;
    private String companyName;
    private String dateOfConfirmation;

    public LegalCustomerModel(BigDecimal customerNumber, String companyName, String dateOfConfirmation) {
        this.customerNumber = customerNumber;
        this.companyName = companyName;
        this.dateOfConfirmation = dateOfConfirmation;
    }
}
