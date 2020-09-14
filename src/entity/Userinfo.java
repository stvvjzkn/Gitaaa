package entity;

public class Userinfo{
    private Integer id;
    private String username;
    private String email;
    private String sex;
    private String area;
    private String info;


    private String user_id;
    private String user_psw;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_psw() {
        return user_psw;
    }

    public void setUser_psw(String user_psw) {
        this.user_psw = user_psw;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public Userinfo(String username, String email, String sex, String area, String info, String password) {
        this.username = username;
        this.email = email;
        this.sex = sex;
        this.area = area;
        this.info = info;
        this.password = password;
    }

    public Userinfo(){

    }
    public Userinfo(String username, String email, String sex, String area, String info) {
        this.username = username;
        this.email = email;
        this.sex = sex;
        this.area = area;
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "user_psw='" + user_psw + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
