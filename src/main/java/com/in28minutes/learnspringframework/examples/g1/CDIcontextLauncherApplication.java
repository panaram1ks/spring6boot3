package com.in28minutes.learnspringframework.examples.g1;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
@Named
class BusinessService {
    DataService dataService;

//    @Autowired
    @Inject
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
        System.out.println("setter injection");
    }

    public DataService getDataService() {
        return dataService;
    }
}

//@Component
@Named
class DataService {

}

@Configuration
@ComponentScan
public class CDIcontextLauncherApplication {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(CDIcontextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BusinessService.class).getDataService());
        }


    }
}
