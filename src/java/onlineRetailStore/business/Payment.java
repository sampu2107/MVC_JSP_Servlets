package onlineRetailStore.business;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Sampath Kumar Gunasekaran Payment Bean model to store the payments
 * made by the user.
 */
public class Payment implements Serializable {

    private String productCode;
    private String username;
    private Date orderDate;

    public Payment() {
        productCode = "";
        username = "";
        orderDate = null;
    }

    public Payment(String productCode, String username, Date orderDate) {
        this.productCode = productCode;
        this.username = username;
        this.orderDate = orderDate;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
