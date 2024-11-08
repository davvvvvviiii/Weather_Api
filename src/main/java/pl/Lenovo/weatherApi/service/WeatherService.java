package pl.Lenovo.weatherApi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private final RestTemplate restTemplate;
    private final String apiKey;
    private final String apiUrl;

    public WeatherService(RestTemplate restTemplate,
                          @Value("${weather.api.key}") String apiKey,
                          @Value("${weather.api.url}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
    }
    public String getWeather(String city) {
        String url = String.format("%s?q=%s&appid=%s&units=metric", apiUrl, city, apiKey);
        return restTemplate.getForObject(url, String.class);
    }
}
