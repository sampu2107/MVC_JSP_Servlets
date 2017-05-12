package onlineRetailStore.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import onlineRetailStore.business.Payment;

/**
 *
 * @author Sampath Kumar Gunasekaran Payment DB Utility class to add payments
 * into the database.
 */
public class PaymentDB {

    public static int addPayment(Payment payment) throws IOException {

        PreparedStatement ps = null;

        String query
                = "INSERT INTO Payment (ProductCode, UserName, OrderDate) "
                + "VALUES (?, ?, ?)";
        try {
            Connection connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, payment.getProductCode());
            ps.setString(2, payment.getUsername());
            java.sql.Date sqlDate = new java.sql.Date(payment.getOrderDate().getTime());
            ps.setDate(3, sqlDate);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
        }
    }
}
