package br.com.ericsoncbizarro.Integracao.cobranca.services.impl;

import br.com.ericsoncbizarro.Integracao.cobranca.model.modelPulsarPay.Cliente;
import br.com.ericsoncbizarro.Integracao.cobranca.exception.BadRequestHttpPulsarPayException;
import br.com.ericsoncbizarro.Integracao.cobranca.services.HttpPulsarPayService;
import br.com.ericsoncbizarro.Integracao.cobranca.services.HttpPulsarPayCliente;
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
public class HttpPulsarPayClienteImpl implements HttpPulsarPayCliente {

    @Autowired
    HttpPulsarPayService httpPulsarPayService;

    public List<Cliente> getClientes() throws Exception {

        httpPulsarPayService.getToken();

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url(HttpPulsarPayService.BASE_URL + "/cliente")
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

    public List<Cliente> postCliente(Cliente clienteBody) throws Exception {

        httpPulsarPayService.getToken();

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        MultipartBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("cliente[nome]", clienteBody.getNome())
                .addFormDataPart("cliente[documento]", clienteBody.getDocumento())
                .addFormDataPart("cliente[data_nascimento]", clienteBody.getData_nascimento())
                .addFormDataPart("endereco[cep]", "99074020")
                .addFormDataPart("endereco[bairro]", "Don Rodolfo")
                .addFormDataPart("endereco[endereco]", "Rua General Daltro Filho")
                .addFormDataPart("endereco[nro]", "1834")
                .addFormDataPart("ibge_code", "4314100")
                .build();

        Request request = new Request.Builder()
                .url(HttpPulsarPayService.BASE_URL + "/cliente")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Authorization", "Bearer " + httpPulsarPayService.getUser().getToken())
                .build();

        Response response = client.newCall(request).execute();

        if (response.code() == 201) {
            String jsonResponse = response.body().string();
            JSONObject objectJsonResponse = new JSONObject(jsonResponse);
            JSONArray arrObjectJsonResponse = objectJsonResponse.getJSONArray("data");

            List<Cliente> clientes = new ArrayList<Cliente>();

            for (int i = 0; i < arrObjectJsonResponse.length(); i++) {
                JSONObject objJSON = (JSONObject) arrObjectJsonResponse.get(i);
                Cliente cliente = deserializePostCliente(objJSON);
                clientes.add(cliente);
            }
            return clientes;
        } else {
            String jsonResponse = response.body().string();
            throw new BadRequestHttpPulsarPayException("Erro Cliente. Code: " + response.code() + " Mensagem: " + jsonResponse);
        }
    }

    private Cliente deserializePostCliente(JSONObject objJSON) throws Exception {
        Cliente cliente = new Cliente();
        cliente.setUpdated_at(objJSON.getString("updated_at"));
        cliente.setData_nascimento(objJSON.getString("data_nascimento"));
        cliente.setConta_id(objJSON.getString("conta_id"));
        cliente.setDocumento(objJSON.getString("documento"));
        cliente.setValidado(objJSON.getString("validado"));
        cliente.setCreated_at(objJSON.getString("created_at"));
        cliente.setNome(objJSON.getString("nome"));
        return cliente;
    }
}