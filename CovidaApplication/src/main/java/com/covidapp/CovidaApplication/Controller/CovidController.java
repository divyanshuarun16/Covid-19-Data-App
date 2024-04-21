package com.covidapp.CovidaApplication.Controller;

import com.covidapp.CovidaApplication.service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/covid-data")
public class CovidController {
    @Autowired
    CovidDataService covidDataService;

    @GetMapping("/{state}/{city}")
    public String getCovidData(@PathVariable String state, @PathVariable String city) throws IOException {
        Object data = covidDataService.getData(state,city);

        return "Covid Data of "+city+", "+state+" is "+data+"";
    }

}
