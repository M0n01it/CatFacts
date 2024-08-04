package ru.netology;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.List;

public class CatFactFetcher {

    private static final String URL = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

    public List<CatFact> fetchCatFacts() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        HttpGet request = new HttpGet(URL);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response.getEntity().getContent(), new TypeReference<List<CatFact>>() {});
        }
    }
}
