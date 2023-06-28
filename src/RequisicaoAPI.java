import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import com.google.gson.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RequisicaoAPI {
    private static final String API_KEY = "yL93Ijryq7fk9y3ujgGSl3k1cjlVaLzNZ6KthNxF";

    /**
     * @param nomeAlimento
     * @param peso
     * @return
     */
    public static ArrayList<Double> requisitarInformacoesAlimento(String nomeAlimento, double peso) {
        ArrayList<Double> resultado = new ArrayList<Double>();
        try {
            // Codificar o nome do alimento para evitar problemas com caracteres especiais
            String alimentoArrumado = URLEncoder.encode(nomeAlimento, StandardCharsets.UTF_8);
            // Faz a requisição para buscar o alimento
            String searchUrl = "https://api.nal.usda.gov/fdc/v1/foods/search?api_key=" + API_KEY + "&query=" + alimentoArrumado;
            String searchData = enviarRequisicaoGet(searchUrl);

            // Obtém o ID do primeiro alimento da resposta da busca
            String foodId = searchData.split("\"fdcId\":")[1].split(",")[0];
            // Faz a requisição para buscar as informações nutricionais do alimento selecionado
            String foodUrl = "https://api.nal.usda.gov/fdc/v1/food/" + foodId + "?api_key=" + API_KEY;

            // Criar um cliente HTTP
            HttpClient cliente = HttpClient.newHttpClient();

            // Criar uma requisição GET
            HttpRequest requisicao = HttpRequest.newBuilder().uri(URI.create(foodUrl)).build();

            // Enviar a requisição e obter a resposta
            HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());

            // Verificar o código de status da resposta
            //200 é uma requisção bem sucedida, se não for 200 houve um erro!
            int statusCode = resposta.statusCode();
            if (statusCode == 200) {
                String res = resposta.body();
                // Converter a resposta JSON em um objeto Java usando a biblioteca Gson
                Gson gson = new Gson();
                //json é um JsonObject que contgém TODA a resposta da API, com todas as informacoes do ingrediente
                JsonObject json = gson.fromJson(res, JsonObject.class);
                //Cirando um JsonElement apenas com as informacoes nutricionais do ingrediente
                JsonElement teste = json.get("labelNutrients");
                if ((json!= null) && (teste != null)){
                    //É retirado as informacoes nutricionais dos alimentos
                    double porcao = 100.0;
                    try{
                        porcao = json.get("servingSize").getAsDouble();
                    } catch (Exception e){
                    }
                    double gordura = 0.0;
                    double caloria = 0.0;
                    double carbo = 0.0;
                    double proteina = 0.0;
                    try{
                        gordura = ((JsonObject) ((JsonObject) teste).get("fat")).get("value").getAsDouble();
                    } catch (Exception e){
                        try{
                            gordura = ((JsonObject) ((JsonObject) teste).get("transFat")).get("value").getAsDouble();
                        } catch (Exception ex){
                            try{
                                gordura = ((JsonObject) ((JsonObject) teste).get("saturatedFat")).get("value").getAsDouble();
                            } catch (Exception exas){
                            }
                        }
                    } 
                    try{
                    caloria = ((JsonObject) ((JsonObject) teste).get("calories")).get("value").getAsDouble();
                    } catch (Exception e){
                    }
                    try{
                        carbo = ((JsonObject) ((JsonObject) teste).get("carbohydrates")).get("value").getAsDouble();
                    } catch (Exception e){
                    }
                    try { proteina = ((JsonObject) ((JsonObject) teste).get("protein")).get("value").getAsDouble();
                    } catch (Exception e){
                    }
                    if (gordura == 0.0 && carbo == 0.0 && proteina == 0.0 && caloria == 0.0){
                        JFrame aviso = new JFrame("Aviso!");
                        JOptionPane.showMessageDialog(aviso, "Este ingrediente não surte efeito na sua dieta!");
                    } else {
                        resultado.add(proteina *(peso/porcao));
                        resultado.add(carbo*(peso/porcao));
                        resultado.add(gordura*(peso/porcao));
                        resultado.add(caloria*(peso/porcao));
                    }
                } else{
                    JFrame aviso = new JFrame("Erro!");
                    JOptionPane.showMessageDialog(aviso, "Nenhum ingrediente encontrado!");
                }
            } else {
                System.out.println("Nenhum alimento encontrado");
            }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            return resultado;
        }
    private static String enviarRequisicaoGet(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}
