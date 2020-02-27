package br.com.ericsoncbizarro.IntegracaoPulsarPay.services.impl;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.exception.BadRequestHttpPulsarPayException;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Produto;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.services.HttpPulsarPayService;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.services.HttpPulsarPayProduto;
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
public class HttpPulsarPayProdutoImpl implements HttpPulsarPayProduto  {

    @Autowired
    HttpPulsarPayService httpPulsarPayService;

    public List<Produto> getProduto() throws Exception {

        httpPulsarPayService.getToken();

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url(HttpPulsarPayService.BASE_URL + "/produto")
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
                List<Produto> produtos = new ArrayList<Produto>();


                for (int i = 0; i < arrObjectJsonResponse.length(); i++) {
                    Object arrJSON = arrObjectJsonResponse.get(i);
                    Produto produto;
                    produto = gson.fromJson(arrJSON.toString(), Produto.class);
                    produtos.add(produto);
                }

                return produtos;

            } catch (Exception e) {
                throw new BadRequestHttpPulsarPayException("Critical Error.");
            }
        } else {
            throw new BadRequestHttpPulsarPayException("Não foi possivel buscar todos os clientes cadastrados na api.");
        }
    }

    public List<Produto> postProduto(Produto produtoBody) throws Exception {

        httpPulsarPayService.getToken();

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        MultipartBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("valor", produtoBody.getValor())
                .addFormDataPart("descricao", produtoBody.getDescricao())
//                .addFormDataPart("ibge_code", "4314100")
                .build();

        Request request = new Request.Builder()
                .url(HttpPulsarPayService.BASE_URL + "/produto")
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
}
