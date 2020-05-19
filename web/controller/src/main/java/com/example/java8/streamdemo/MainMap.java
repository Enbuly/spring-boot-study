package com.example.java8.streamdemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 主测试类
 *
 * @author lazy cat
 * 2020-05-19
 **/
public class MainMap {

    //filter过滤数据
    //map函数的作用就是针对管道流中的每一个数据元素进行转换操作。
    public static void main(String[] args) {
        Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
        Employee e2 = new Employee(2, 13, "F", "Martina", "Hengis");
        Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
        Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman");
        Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria");
        Employee e6 = new Employee(6, 15, "M", "David", "Feezor");
        Employee e7 = new Employee(7, 68, "F", "Melissa", "Roy");
        Employee e8 = new Employee(8, 79, "M", "Alex", "Gussin");
        Employee e9 = new Employee(9, 15, "F", "Neetu", "Singh");
        Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");


        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);

        //用map
        /*List<Employee> list = employees.stream()
                .map(e -> {
                    e.setAge(e.getAge() + 1);
                    e.setGender(e.getGender().equals("M") ? "male" : "female");
                    return e;
                }).collect(Collectors.toList());*/

        //返回值与传入参数一致，用peek代替map
        /*List<Employee> list = employees.stream()
                .filter(e -> e.getId() > 4)
                .peek(e -> {
                    e.setAge(e.getAge() + 1);
                    e.setGender(e.getGender().equals("M") ? "male" : "female");
                }).collect(Collectors.toList());*/

        //使用谓语
        List<Employee> list = employees.stream()
                .parallel()
                .filter(Employee.idMaxFour.negate())
                .peek(e -> {
                    e.setAge(e.getAge() + 1);
                    e.setGender(e.getGender().equals("M") ? "male" : "female");
                }).collect(Collectors.toList());

        for (Employee employee : list) {
            System.out.println(employee.toString());
        }
    }
}
