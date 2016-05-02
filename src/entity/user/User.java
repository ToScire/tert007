package entity.user;

/**
 * Created by Alexander on 16.02.2016.
 */
public class User {
    private int id;
    private UserType userType;
    private String login;
    private String password;
    private String email;
    private int bonusCount;

    public User() {
    }

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User(int id, UserType userType, String login, String password, String email, int bonusCount) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.bonusCount = bonusCount;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBonusCount() {
        return bonusCount;
    }

    public void setBonusCount(int bonusCount) {
        this.bonusCount = bonusCount;
    }

}
