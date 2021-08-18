package com.sg.jdbctcomplexexample;

/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 
 */



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 
 * @author Steven
 */
@Configuration
@ComponentScan(
    excludeFilters = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE, 
        value = CommandLineRunner.class
    )
)
@EnableAutoConfiguration
public class TestApplicationConfiguration {

}