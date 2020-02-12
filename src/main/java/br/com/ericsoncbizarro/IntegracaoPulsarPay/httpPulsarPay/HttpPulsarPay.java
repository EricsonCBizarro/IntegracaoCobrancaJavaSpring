package br.com.ericsoncbizarro.IntegracaoPulsarPay.httpPulsarPay;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.exception.BadRequestHttpPulsarPayException;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Cliente;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.User;
import com.google.gson.Gson;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HttpPulsarPay {

    private String BASE_URL = "https://api-sandbox.pulsarpay.com/api";

    private User user = new User(">QcU]W0a!!{}7ZPeLYzbstBC!vwg+VgfuTqVwm3J", "123456");

    private Logger logger = LoggerFactory.getLogger(HttpPulsarPay.class);

    private void getToken() throws Exception {

//        if (user.getToken() == null) {

            // TODO Validar e o token é valido.. por enquanto sempre pega o token

            OkHttpClient client = new OkHttpClient().newBuilder().build();

            MultipartBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("email", user.getEmail())
                    .addFormDataPart("password", user.getPassword())
                    .build();

            Request request = new Request.Builder()
                    .url(BASE_URL + "/usuario/login")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .addHeader("Cache-Control", "no-cache")
                    .build();

            Response response = client.newCall(request).execute();

            if (response.code() == 200) {
                try {
                    String jsonResponse = response.body().string();

                    Gson gson = new Gson();
                    User userResponse;
                    userResponse = gson.fromJson(jsonResponse, User.class);
                    user.setToken(userResponse.getToken());

                } catch (Exception e) {
                    throw new BadRequestHttpPulsarPayException("Token não recuperado.");
                }
            } else {
                String jsonResponse = response.body().string();
                throw new BadRequestHttpPulsarPayException("Token não recuperado. Codigo: " + response.code() + " Mensagem: " + jsonResponse);
            }
//        }

    }

    public List<Cliente> getClientes() throws Exception {

        getToken();

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url(BASE_URL + "/cliente")
                .method("GET", null)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Authorization", "Bearer " + user.getToken())
                .build();

        Response response = client.newCall(request).execute();

        if (response.code() == 200) {
            try {
                String jsonResponse = response.body().string();
                JSONObject objectJsonResponse = new JSONObject(jsonResponse);
                JSONArray arrObjectJsonResponse = objectJsonResponse.getJSONArray("data");

                Gson gson = new Gson();
                List<Cliente> clientes = new ArrayList<Cliente>();

                for (int i = 0; i < arrObjectJsonResponse.length(); i++) {
                    Object arrJSON = arrObjectJsonResponse.get(i);
                    Cliente cliente;
                    cliente = gson.fromJson(arrJSON.toString(), Cliente.class);
                    clientes.add(cliente);
                }

                return clientes;

            } catch (Exception e) {
                throw new BadRequestHttpPulsarPayException("Critical Error.");
            }
        } else {
            throw new BadRequestHttpPulsarPayException("Não foi possivel buscar todos os clientes cadastrados na api.");
        }
    }

    public Cliente postCliente(Cliente cliente) throws Exception {

        getToken();

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        MultipartBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("nome", cliente.getNome())
                .addFormDataPart("documento", cliente.getDocumento())
                .addFormDataPart("data_nascimento", cliente.getDocumento())
                .build();

        Request request = new Request.Builder()
                .url(BASE_URL + "/cliente")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Authorization", "Bearer " + user.getToken())
                .build();

        Response response = client.newCall(request).execute();

        if (response.code() == 200) {

            return null;
        } else {
            String jsonResponse = response.body().string();
            throw new BadRequestHttpPulsarPayException("Erro Cliente. Code: " + response.code() + " Mensagem: " + jsonResponse);
        }
    }
}
