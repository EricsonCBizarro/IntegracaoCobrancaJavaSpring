package br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.Objects;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
public class User {

    // @TODO usar notação camelCase... trocar pp_token por ppToken etc...
    private String pp_token;
    private String password; // @TODO padronizar... em PT-BR ou em ingles?
    private String email;
    private String token;

    public User(String pp_token,String password) {
        this.pp_token = pp_token;
        this.password = password;
    }

    // @TODO porque reimplementou equals e hash code aqui mas nao em Boleto? necessário?
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
