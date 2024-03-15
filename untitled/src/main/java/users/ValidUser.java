package users;

public class ValidUser {

    private String bankId;
    private String username;
    private String password;

    public String getBankId() {
        return this.bankId;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setBankId() {
        this.bankId = "008463";
    }

    public void setUsername() {
        this.username = "User1";
    }

    public void setPassword(String password) {
        this.password = "12689";
    }
}
