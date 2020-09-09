package br.com.ericsoncbizarro.IntegracaoPulsarPay.feign;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Boleto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.List;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
public class BoletoDTO {
    private List<Boleto> data;
}
