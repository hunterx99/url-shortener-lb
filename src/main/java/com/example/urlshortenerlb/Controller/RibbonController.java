package com.example.urlshortenerlb.Controller;

import com.example.urlshortenerlb.Configuration.RibbonConfiguration;
import com.example.urlshortenerlb.Entity.UrlShortenerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RibbonClient(name = "url-shortener-lb", configuration = RibbonConfiguration.class)
public class RibbonController {

    private final RestTemplate template;

    public RibbonController(RestTemplate template) {
        this.template = template;
    }

    @GetMapping("/")
    public String getAllUrls() {
        System.out.println("Here.......");
        String url = "http://url-shortener/all";
        return template.getForObject(url, String.class);
    }

    @GetMapping("/{id}")
    public String ShortUrlToLong(@PathVariable String id) {
        System.out.println("Here.......");
        String url = "http://url-shortener/" + id;
        return template.getForObject(url, String.class);
    }
    @RequestMapping(value="/", method = RequestMethod.POST)
    public String longUrlToShortUrl(@RequestBody UrlShortenerEntity urlShortenerEntity){
        String url = "http://url-shortener/";
        return template.postForObject(url, urlShortenerEntity, String.class);
    }
}
