package common.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    public User() {
    }

    public User(Long id, String name, String login) {
        this.id = id;
        this.name = name;
        this.login = login;
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User(Long id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User(String name, String login, String password, String role) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(Long id, String name, String login, String password, String role) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name = '" + name + '\'' +
                "login = '" + login + '\'' +
                ", password = '" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login.equals(user.login) && password.equals(user.password)) {
            return true;
        }
        return false;

    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode() ;
        return result;
    }
}
