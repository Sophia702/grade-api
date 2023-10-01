import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
public class Main {
    private static final String API_TOKEN = "1b1f342ee2a54ef39cd07aabf1809ef1";
    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://api.spoonacular.com/recipes/complexSearch?apiKey=%s&cuisine=thai&intolerance=gluten&number=1", API_TOKEN))
                .addHeader("Content-Type", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

            System.out.println(responseBody.toString());

        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}