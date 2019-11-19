package net.mgrabiec.weather;

import com.fasterxml.jackson.databind.JsonNode;
import net.mgrabiec.weather.model.CityWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class WeatherController {
    private WheatherService service;

    @Autowired
    public WeatherController(WheatherService service) {
        this.service=service;
    }


    @RequestMapping(value = "/city", method = GET)
    public String get(@RequestParam("name") String name, Model model) {
        model.addAttribute("cityWeather", service.getCityWeather(name));
        return "cityView";
    }
    @GetMapping
    public String indx() {
        return "index";
    }
}
