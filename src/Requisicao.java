import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Requisicao {

    public Endereco consultaEndereco(String cep) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        HttpResponse<String> response =client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Endereco endereco = gson.fromJson(json, Endereco.class);

        return endereco;

    }
}
