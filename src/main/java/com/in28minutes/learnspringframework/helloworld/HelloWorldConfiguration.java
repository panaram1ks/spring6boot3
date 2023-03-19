package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//Eliminate verbosity in creating Java Beans
//Public accessor methods, constructor,
//equals, hashcode and toString are automatically created.
//Released in JDK 16.

record Person(String name, int age, Address address) {
}

//Address - firstLine & city
record Address(String firstLine, String city) {
}


@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Runga";
    }

    @Bean
    public int age() {
        return 10;
    }



    @Bean(name = "yourCustomBeanName")
    @Primary
    public Address address() {
        var address = new Address("BackerStreet", "London");
        return address;
    }

    @Bean(name = "address3")
    public Address address3() {
        var address = new Address("Matinagar", "Hyberabad");
        return address;
    }

    @Bean(name = "address4")
    @Qualifier("address4qualifier")
    public Address address4() {
        var address = new Address("444", "4");
        return address;
    }
    @Bean
    @Qualifier("personQualifier")
    public Person person() {
        var person = new Person("Ravi", 20, address());
        return person;
    }

    @Bean
    public Person person2MethodCall(){
        return new Person(name(), age(), address()); //name, age
    }

    @Bean
    public Person person3Parameters(String name, int age, @Qualifier("address4qualifier") Address address){
        //name,age,address3
        return new Person(name, age, address);
    }

//    @Bean
//    public Person person4Parameters(String name, int age, Address address){
//        return new Person(name, age, address);
//    }
}
