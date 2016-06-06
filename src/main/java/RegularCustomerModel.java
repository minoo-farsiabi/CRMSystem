import java.math.BigDecimal;

/**
 * Created by m.farsiabi on 6/5/2016.
 */
public class RegularCustomerModel{
    private BigDecimal customerNumber;
    private String firstname;
    private String lastname;
    private String fathername;
    private String dateOfBirth;
    private BigDecimal nationalId;

    public BigDecimal getCustomerNumber() {
        return customerNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFathername() {
        return fathername;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public BigDecimal getNationalId() {
        return nationalId;
    }

    public RegularCustomerModel(BigDecimal customerNumber, String firstname, String lastname, String fathername, String dateOfBirth, BigDecimal nationalId) {
        this.customerNumber = customerNumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.fathername = fathername;
        this.dateOfBirth = dateOfBirth;
        this.nationalId = nationalId;
    }
}
