package com.covidapp.CovidaApplication.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;


import java.util.Map;

import org.springframework.stereotype.Service;
@Service
public class CovidDataService {
    @Autowired
    RestTemplate restTemplate;

    public Object getData(String state,String city){
       //                                                                                                                                                                                                                                                         String usableState = state.substring(0,1).toUpperCase()+state.substring(1).toLowerCase();
        String usablecity = city.substring(0,1).toUpperCase()+city.substring(1).toLowerCase();

        Map<String, Object> forObject = restTemplate.getForObject("https://data.covid19india.org/v4/min/data.min.json", Map.class);
        Map<String, Object> stateData = (Map<String, Object>) forObject.get(state);
        Map<String, Object> districtData = (Map<String, Object>) stateData.get("districts");
        Map<String,Object> o = (Map<String,Object>)districtData.get(usablecity);
        Object ans = o.get("total");

        System.out.println(o);
        return ans;
    }

}
