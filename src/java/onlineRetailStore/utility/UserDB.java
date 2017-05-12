package onlineRetailStore.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import onlineRetailStore.business.User;

/**
 *
 * @author Sampath Kumar Gunasekaran User DB Utility class to get User details
 * from the database.
 */
public class UserDB {

    public static User getUser(String emailAddress) throws IOException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM User "
                + "WHERE Email = ?";
        try {
            Connection connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, emailAddress);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setUserName(rs.getString("UserName"));
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
                user.setType(rs.getString("Type"));
                user.setNumCart(Integer.parseInt(rs.getString("NumCart")));
                user.setNumCredits(Integer.parseInt(rs.getString("NumCredits")));
                user.setNumOffers(Integer.parseInt(rs.getString("NumOffers")));
            }
            connection.close();
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }

    }

    public static ArrayList<User> getUsers() throws IOException {

        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM User ";
        try {
            Connection connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            User user = null;
            ArrayList<User> users = new ArrayList<>();
            while (rs.next()) {
                user = new User();
                user.setUserName("UserName");
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
                user.setType(rs.getString("Type"));
                user.setNumCart(Integer.parseInt(rs.getString("NumCart")));
                user.setNumCredits(Integer.parseInt(rs.getString("NumCredits")));
                user.setNumOffers(Integer.parseInt(rs.getString("NumOffers")));
                users.add(user);
            }
            connection.close();
            return users;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static int addUser(User user) throws IOException {

        PreparedStatement ps = null;
        Connection connection = null;
        String query
                = "INSERT INTO User (UserName, Name, Email, Password, Type, NumCart, NumCredits, NumOffers) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getType());
            ps.setInt(6, user.getNumCart());
            ps.setInt(7, user.getNumCredits());
            ps.setInt(8, user.getNumOffers());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
