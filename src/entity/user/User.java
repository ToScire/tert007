package entity.user;

/**
 * Created by Alexander on 16.02.2016.
 */
public class User {
    private int id;
    private int user_type_id;
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

    public User(int id, String login, String password, String email, int bonusCount) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.bonusCount = bonusCount;
    }

    public String[] getValues(){
        String[] result = new String[6];
        result[0]= String.valueOf(id);
        result[1]=String.valueOf(user_type_id);
        result[2]=login;
        result[3]=password;
        result[4]=email;
        result[5]=String.valueOf(bonusCount);
        return result;
    }

    public void setUserType(int type){
        this.user_type_id = type;
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
