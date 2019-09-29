package com.example.mapper2;

import com.example.model.City;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * city mapper
 *
 * @author lazy cat
 * @since 2019-09-29
 **/
@Mapper
public interface CityMapper {

    /**
     * 查找所有的城市信息
     **/
    List<City> selectCity();
}
