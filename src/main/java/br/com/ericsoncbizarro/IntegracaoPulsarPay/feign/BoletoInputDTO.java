package br.com.ericsoncbizarro.IntegracaoPulsarPay.feign;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
public class BoletoInputDTO {
     private Map boleto = new HashMap();
     private String documento; // A API exige um CNPJ válido
     private String data_nascimento; // API exige string em formato Y-m-d
}
