package net.mgrabiec.weather;

import com.fasterxml.jackson.databind.JsonNode;
import net.mgrabiec.weather.model.CityWeather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import net.mgrabiec.weather.model.*;

@Service
public class WheatherService {


    public CityWeather getCityWeather(String cityName) {
        RestTemplate restTemplate = new RestTemplate();
        String cityId = restTemplate.getForObject("https://www.metaweather.com/api/location/search/?query="+cityName, JsonNode.class).get(0).get("woeid").toString();
        CityWeather cityWeather;
        cityWeather = restTemplate.getForObject("https://www.metaweather.com/api/location/"+cityId, CityWeather.class);
        return cityWeather;
    }
}
