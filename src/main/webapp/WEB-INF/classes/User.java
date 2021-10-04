import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String login;
    private String pass;
    private String email;

    public User(String pass, String email) {
        this.pass = pass;
        this.email = email;
    }

    public User(String login, String pass, String email) {
        this.login = login;
        this.pass = pass;
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }
}
