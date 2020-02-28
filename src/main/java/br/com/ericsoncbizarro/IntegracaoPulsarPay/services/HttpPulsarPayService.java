package br.com.ericsoncbizarro.IntegracaoPulsarPay.services;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.exception.BadRequestHttpPulsarPayException;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.User;
import com.google.gson.Gson;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HttpPulsarPayService {

    public static final String BASE_URL = "https://api-sandbox.pulsarpay.com/api";
    private User user = new User(">QcU]W0a!!{}7ZPeLYzbstBC!vwg+VgfuTqVwm3J", "123456");
    private Logger logger = LoggerFactory.getLogger(HttpPulsarPayService.class);

    public User getUser() {
        return this.user;
    }

    public void getToken() throws Exception {

//        if (user.getToken() == null) {

            // TODO Validar e o token é valido.. por enquanto sempre pega o token

            OkHttpClient client = new OkHttpClient().newBuilder().build();

            MultipartBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("pp_token", user.getPp_token())
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


}
