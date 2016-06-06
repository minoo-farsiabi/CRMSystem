import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by m.farsiabi on 6/5/2016.
 */

public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        List<RegularCustomerModel> allRegularCustomers = RegularCustomerController.getInstance().getAllCustomers();

        PrintWriter out = response.getWriter();

        out.println("<HTML>\n<HEAD>");
        out.println("<TITLE>" + "مشتریان حقیقی" + "</TITLE></HEAD>");
        out.println("<BODY dir=\"rtl\">\n");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"MyStyles.css\" media=\"screen\" />");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<link rel=\"stylesheet\" href=\"http://www.w3schools.com/lib/w3.css\">\n" +
                "<link rel=\"stylesheet\" href=\"http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css\">");

        out.println("<P ALIGN='center'><TABLE id = \"customers\">");

        out.println("<TR>");

        out.println("<TH>" + "شماره مشتری" + "</TH>");
        out.println("<TH>" + "نام" + "</TH>");
        out.println("<TH>" + "نام خانوادگی" + "</TH>");
        out.println("<TH>" + "نام پدر" + "</TH>");
        out.println("<TH>" + "تاریخ تولد" + "</TH>");
        out.println("<TH>" + "کد ملی" + "</TH>");

        out.println("</TR>");
        // the data
        for (RegularCustomerModel regularCustomerModel: allRegularCustomers) {
            out.println("<TR>");
            out.println("<TD>" + regularCustomerModel.getCustomerNumber().toString() + "</TD>");
            out.println("<TD>" + regularCustomerModel.getFirstname() + "</TD>");
            out.println("<TD>" + regularCustomerModel.getLastname() + "</TD>");
            out.println("<TD>" + regularCustomerModel.getFathername() + "</TD>");
            out.println("<TD>" + regularCustomerModel.getDateOfBirth() + "</TD>");
            out.println("<TD>" + regularCustomerModel.getNationalId().toString() + "</TD>");
            out.println("</TR>");
        }
        out.println("</TABLE></P>");

        out.println("<P><a href=\"http://google.com\">");
        out.println("<button class=\"button smallButton\">+</button>");
        out.println("</a></P>");

        out.println("</BODY></HTML>");
    }
}
