package dev.vimukthi.sentura_interview.service;
import com.squareup.okhttp.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeavyClient {
    private final OkHttpClient httpClient = new OkHttpClient();

    public String getWeavyAllUserData(String url, String apiKey) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        Response response = httpClient.newCall(request).execute();
        try {
            return response.body().string();
        } finally {
            response.body().close();
        }
    }

    public String postWeavyData(String url, String apiKey, String jsonBody) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonBody);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        Response response = httpClient.newCall(request).execute();
        try {
            return response.body().string();
        } finally {
            response.body().close();
        }
    }
}
