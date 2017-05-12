package onlineRetailStore.business;

import java.io.Serializable;

/**
 *
 * @author Sampath Kumar Gunasekaran Product Bean model to represent the product
 * details.
 */
public class Product implements Serializable {

    private String productName;
    private String productCode;
    private String productDesc;
    private String productAddedDate;
    private String productOrderEmail;
    private int quantity;
    private int price;
    private String status;
    private String category;

    public Product() {
        productName = "";
        productCode = "";
        productDesc = "";
        productOrderEmail = "";
        productAddedDate = "";
        quantity = 0;
        price = 0;
        status = "";
        category = "";
    }

    public Product(String productName, String productCode, String productDesc, String productAddedDate, int quantity, int price, String status, String category, String productOrderEmail) {
        this.productName = productName;
        this.productCode = productCode;
        this.productDesc = productDesc;
        this.productAddedDate = productAddedDate;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.category = category;
        this.productOrderEmail = productOrderEmail;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductAddedDate() {
        return productAddedDate;
    }

    public void setProductAddedDate(String productAddedDate) {
        this.productAddedDate = productAddedDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductOrderEmail() {
        return productOrderEmail;
    }

    public void setProductOrderEmail(String productOrderEmail) {
        this.productOrderEmail = productOrderEmail;
    }

    /* URL that can be used in your pages that points to an image file within the project for the product. Generated from product code*/
    public String getImageURL(String productCode) {
        String imageURL = "";
        if (productCode.startsWith("sp")) {
            imageURL = "images/3.jpg";
        } else if (productCode.startsWith("el")) {
            imageURL = "images/2.jpg";
        } else if (productCode.startsWith("cl")) {
            imageURL = "images/1.jpg";
        } else {
            imageURL = "images/4.jpg";
        }
        return imageURL;
    }
}
