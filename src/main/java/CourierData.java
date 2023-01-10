public class CourierData {
    private String login;
    private String password;
    private String firstname;

    public CourierData(String login, String password, String firstname) {
        this.login = login;
        this.password = password;
        this.firstname = firstname;
    }
    public CourierData() {
    }
    public CourierData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
