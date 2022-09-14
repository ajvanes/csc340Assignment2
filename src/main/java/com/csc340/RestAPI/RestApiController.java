/*
 * Name: Andrew Van Es
 * Project: Test and use API's
 * Date Modified: 09/14/2022
 * Assignment 2 - API
 *
 * Integrity Policy Statement
 * My words and actions will reflect Academic Integrity
 * I will not cheat or lie or steal in academic matters
 * I will promote integrity in the UNCG community.
 * Student’s Signature: Andrew Van Es    Date: 09/14/2022
 */
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
        String siteUrl = "https://api.ipify.org?format=json";
        RestTemplate restTemp = new RestTemplate();
        Object jSonIP = restTemp.getForObject(siteUrl, Object.class);

        String ip = restTemp.getForObject(siteUrl, String.class);

        // Parse the IP address from the response
        JSONObject jSONObj = new JSONObject(ip);
        System.out.println(jSONObj.toString());
        String ipAddress = jSONObj.getString("ip");
        System.out.println(ipAddress);

        return jSonIP;
    }

}
