package com.example.springframeworklearn.models.section1.game_model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Primary
public class MyWebController {
    @Autowired
    private BusinessService businessService;
    public long returnValueFromBusinessService() {
        return businessService.calculateSum();
    }
}

@Component
class BusinessService {
    private DataService dataService;


    public DataService getDataService() {
        return dataService;
    }

    @Autowired
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }
    
    public long calculateSum() {
        List<Integer> data = dataService.getData();
        return data.stream().reduce(Integer::sum).get();
    }
}

@Component
class DataService {
    public List<Integer> getData() {
        return Arrays.asList(10, 20, 30, 40);
    }
}
