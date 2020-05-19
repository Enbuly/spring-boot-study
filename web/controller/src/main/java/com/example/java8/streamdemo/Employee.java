package com.example.java8.streamdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.function.Predicate;

/**
 * madel
 *
 * @author lazy cat
 * 2020-05-19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Employee {
    public static Predicate<Employee> idMaxFour = x -> x.getId() < 4;
    private Integer id;
    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;
}
