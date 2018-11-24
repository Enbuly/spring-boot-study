package org.spring.springboot.dubbo.api;


import org.spring.springboot.domain.City;

/**
 * @author zhangzy
 * @email 120157229@qq.com
 * @since 11-21
 **/
public interface CityDubboService {
    City findCityByName(String cityName);
}
