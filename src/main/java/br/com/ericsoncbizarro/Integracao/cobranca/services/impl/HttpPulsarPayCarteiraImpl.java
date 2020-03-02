package br.com.ericsoncbizarro.Integracao.cobranca.services.impl;

import br.com.ericsoncbizarro.Integracao.cobranca.exception.BadRequestHttpPulsarPayException;
import br.com.ericsoncbizarro.Integracao.cobranca.model.modelPulsarPay.Carteira;
import br.com.ericsoncbizarro.Integracao.cobranca.services.HttpPulsarPayCarteira;
import br.com.ericsoncbizarro.Integracao.cobranca.services.HttpPulsarPayService;
import com.google.gson.Gson;
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
public class HttpPulsarPayCarteiraImpl implements HttpPulsarPayCarteira {

    @Autowired
    HttpPulsarPayService httpPulsarPayService;

    public List<Carteira> getCarteiras() throws Exception {

        httpPulsarPayService.getToken();

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url(HttpPulsarPayService.BASE_URL + "/carteira")
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
                List<Carteira> carteiras = new ArrayList<Carteira>();

                for (int i = 0; i < arrObjectJsonResponse.length(); i++) {
                    Object arrJSON = arrObjectJsonResponse.get(i);
                    Carteira carteira;
                    carteira = gson.fromJson(arrJSON.toString(), Carteira.class);
                    carteiras.add(carteira);
                }

                return carteiras;

            } catch (Exception e) {
                throw new BadRequestHttpPulsarPayException("Critical Error.");
            }
        } else {
            throw new BadRequestHttpPulsarPayException("Não foi possivel buscar todos os clientes cadastrados na api.");
        }
    }

}
