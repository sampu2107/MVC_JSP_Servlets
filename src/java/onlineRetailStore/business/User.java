package onlineRetailStore.business;

import java.io.Serializable;

/**
 *
 * @author Sampath Kumar Gunasekaran User Bean model to represent the user
 * details.
 */
public class User implements Serializable {

    private String username;
    private String password;
    private String name;
    private String email;
    private String type;
    int numCart;
    int numCredits;
    int numOffers;

    public User() {
        username = "";
        password = "";
        name = "";
        email = "";
        password = "";
        type = "";
        numCart = 0;
        numCredits = 0;
        numOffers = 0;
    }

    public User(String username, String name, String email, String password, String type, int numCart, int numCredits, int numOffers) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
        this.numCart = numCart;
        this.numCredits = numCredits;
        this.numOffers = numOffers;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumCart() {
        return numCart;
    }

    public void setNumCart(int numCart) {
        this.numCart = numCart;
    }

    public int getNumCredits() {
        return numCredits;
    }

    public void setNumCredits(int numCredits) {
        this.numCredits = numCredits;
    }

    public int getNumOffers() {
        return numOffers;
    }

    public void setNumOffers(int numOffers) {
        this.numOffers = numOffers;
    }
}
