package br.com.ericsoncbizarro.IntegracaoPulsarPay.services.impl;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.exception.BadRequestHttpPulsarPayException;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Boleto;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.services.HttpPulsarPay;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.services.HttpPulsarPayBoleto;
import com.google.gson.Gson;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class HttpPulsarPayBoletoImpl implements HttpPulsarPayBoleto {

    @Autowired
    HttpPulsarPay httpPulsarPayService;

    public List<Boleto> getBoletos() throws Exception {

        httpPulsarPayService.getToken();

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url(HttpPulsarPay.BASE_URL + "/boleto/listar")
                .method("GET", null)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Authorization", "Bearer " + httpPulsarPayService.getUser().getToken())
                .build();

        Response response = client.newCall(request).execute();

        if (response.code() == 200) {
            try {
                String jsonResponse = response.body().string();
                JSONObject objectJsonResponse = new JSONObject(jsonResponse);
                JSONArray arrObjectJsonResponse = objectJsonResponse.getJSONArray("data");

                Gson gson = new Gson();
                List<Boleto> boletos = new ArrayList<Boleto>();

                for (int i = 0; i < arrObjectJsonResponse.length(); i++) {
                    Object arrJSON = arrObjectJsonResponse.get(i);
                    Boleto boleto;
                    boleto = gson.fromJson(arrJSON.toString(), Boleto.class);
                    boletos.add(boleto);
                }

                return boletos;

            } catch (Exception e) {
                throw new BadRequestHttpPulsarPayException("Critical Error.");
            }
        } else {
            throw new BadRequestHttpPulsarPayException("Não foi possivel buscar todos os clientes cadastrados na api.");
        }
    }

    public List<Boleto> postBoleto(Boleto boletoBody) throws Exception {

        httpPulsarPayService.getToken();

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        MultipartBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("boleto[valor_total]", boletoBody.getValor_total())
                .addFormDataPart("documento", boletoBody.getDocumento())
                .addFormDataPart("data_nascimento", boletoBody.getData_nascimento())
                .addFormDataPart("boleto[vencimento]", boletoBody.getVencimento())
                .build();

        Request request = new Request.Builder()
                .url(HttpPulsarPay.BASE_URL + "/boleto/gerar")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Authorization", "Bearer " + httpPulsarPayService.getUser().getToken())
                .build();

        Response response = client.newCall(request).execute();

        if (response.code() == 201) {
            return null;
        } else {
            String jsonResponse = response.body().string();
            throw new BadRequestHttpPulsarPayException("Erro Cliente. Code: " + response.code() + " Mensagem: " + jsonResponse);
        }
    }

    private Boleto deserializePostBoleto(JSONObject objJSON) throws Exception {
        Boleto boleto = new Boleto();

        boleto.setNosso_numero(objJSON.getString("nosso_numero"));

        return boleto;
    }
}
