package pl.Lenovo.weatherApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.Lenovo.weatherApi.service.WeatherService;

@RestController
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    @GetMapping("/weather/{city}")
    public String getWeather(@PathVariable("city") String city){
        return weatherService.getWeather(city);
    }
}
