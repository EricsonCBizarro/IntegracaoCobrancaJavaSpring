package br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay;

import java.util.Objects;

public class User {

    private String pp_token;
    private String password;
    private String email;
    private String token;

    public User () {

    }

    public User(String pp_token,String password) {
        this.pp_token = pp_token;
        this.password = password;
    }

    public String getPp_token() {
        return pp_token;
    }

    public void setPp_token(String pp_token) {
        this.pp_token = pp_token;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(pp_token, user.pp_token) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(token, user.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pp_token, password, email, token);
    }
}
