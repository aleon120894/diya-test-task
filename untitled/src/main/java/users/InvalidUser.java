package users;

public class InvalidUser {

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
        this.bankId = "000000";
    }

    public void setUsername() {
        this.username = "User";
    }

    public void setPassword(String password) {

        this.password = "11111";
    }
}
