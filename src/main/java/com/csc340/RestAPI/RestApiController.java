package com.csc340.RestAPI;

import org.json.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * This method uses an API to obtain and show the users IP address
 *
 * @author Andrew Van Es
 */
@RestController
public class RestApiController {

    @GetMapping("/ip")
    public Object getThing() {
        String url = "https://api.ipify.org?format=json";
        RestTemplate restTemplate = new RestTemplate();
        Object jSonIP = restTemplate.getForObject(url, Object.class);
        
        String ipAddress = restTemplate.getForObject(url, String.class);

        // Parse the IP address from the response
        JSONObject jo = new JSONObject(ipAddress);
        System.out.println(jo.toString());
        String quoteAuthor = jo.getString("ip");
        System.out.println(quoteAuthor);

        return jSonIP;
    }

}
