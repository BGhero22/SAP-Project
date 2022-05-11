import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class Clients<size> {
    private String username;
    private String password;
    private String email;
    private String egn;
    private boolean isAdmin;

    public Clients(String username, String password, String email, String egn, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.egn = egn;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clients)) return false;
        Clients<?> clients = (Clients<?>) o;
        return isAdmin() == clients.isAdmin() && getUsername().equals(clients.getUsername()) && getPassword().equals(clients.getPassword()) && getEmail().equals(clients.getEmail()) && getEgn().equals(clients.getEgn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassword(), getEmail(), getEgn(), isAdmin());
    }

}
