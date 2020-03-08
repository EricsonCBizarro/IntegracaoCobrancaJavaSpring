package br.com.ericsoncbizarro.IntegracaoPulsarPay.feign;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Getter
@Setter
@Accessors(chain=false) // necessário para usar BeanUtils.copyProperties
@NoArgsConstructor
// Exemplo de JSON retornado ao criar novo boleto
// {"status":201,"mensagem":"Sucesso","data":{"337924":{"boleto_id":337924,"nosso_numero":921368,"credito_id":334950,"vencimento":"23\/04\/2020","valor":"1450.00","hash_boleto":{"p":"52804","i":"5e69c7c5"},"link_boleto":"https:\/\/api-sandbox.pulsarpay.com\/api\/boleto\/visualizar?p=52804&i=5e69c7c5","linha_digitavel":"75691.30367 01034.672103 09213.680011 8 82340000145000","codigo_barras":"75698823400001450001303601034672100921368001"}}}
public class BoletoOutputDTO {

    private String status;
    private String mensagem;
    private Integer boleto_id;
    private Integer nosso_numero;
    private Integer credito_id;
    private String vencimento;
    private String valor;
    private String link_boleto;
    private String linha_digitavel;
    private String codigo_barras;

    @JsonProperty("data")
    private void unpackNested(Map<String,Object> dataObj) throws InvocationTargetException, IllegalAccessException {
        Iterator iterator = dataObj.keySet().iterator();
        if(dataObj.keySet().iterator().hasNext()){
            String chave = (String) iterator.next();
            Map<String,Object> innerData = (HashMap<String, Object>) dataObj.get(chave);
            BeanUtils.copyProperties(this, innerData);
        }

    }

}
