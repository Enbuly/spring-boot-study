package org.spring.springboot.dubbo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.spring.springboot.domain.City;
import org.spring.springboot.dubbo.service.CityDubboConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangzy
 * @email 120157229@qq.com
 * @since 11-21
 **/
@Api(tags = {"CityController-zhangzy"}, description = "city interface")
@RestController
@SpringBootApplication
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    CityDubboConsumerService cityDubboConsumerService;

    @ApiOperation("findCityByName")
    @RequestMapping(value = "/findCityByName", method = RequestMethod.GET)
    City findCityByName(@RequestParam String cityName) {
        return cityDubboConsumerService.printCity(cityName);
    }

}
