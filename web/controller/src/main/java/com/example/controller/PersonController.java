package com.example.controller;

import com.example.model.Person;
import com.example.util.EasyPoiUtil;
import io.swagger.annotations.Api;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangzy
 * @email 120157229@qq.com
 * @since 12-26
 **/
@Api(tags = {"easy poi example"}, description = "easy poi example")
@RestController
@SpringBootApplication
@RequestMapping(value = "/person")
public class PersonController {

    //访问localhost:8080/person/export测试
    @GetMapping("/export")
    public void export(HttpServletResponse response) {

        //模拟从数据库获取需要导出的数据
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person("路飞", "1", new Date());
        Person person2 = new Person("娜美", "2", new Date());
        Person person3 = new Person("索隆", "1", new Date());
        Person person4 = new Person("小狸猫", "1", new Date());

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        EasyPoiUtil.exportExcel(personList, "花名册",
                "草帽一伙", Person.class, "海贼王.xls", response);
    }

    @GetMapping("/importExcel")
    public void importExcel() {
        String filePath = "F:\\海贼王.xls";
        //解析excel，
        List<Person> personList = EasyPoiUtil.importExcel(filePath, 1,
                1, Person.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file,
        // Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【" + personList.size() + "】行");
    }

}
