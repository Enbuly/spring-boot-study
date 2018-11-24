package org.spring.springboot.dubbo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.spring.springboot.domain.City;
import org.spring.springboot.dubbo.api.CityDubboService;
import org.springframework.stereotype.Component;

/**
 * @author zhangzy
 * @email 120157229@qq.com
 * @since 11-21
 **/
@Component
public class CityDubboConsumerService {

    @Reference(version = "1.0.0")
    CityDubboService cityDubboService;

    public City printCity(String cityName) {
        return cityDubboService.findCityByName(cityName);
    }
}
