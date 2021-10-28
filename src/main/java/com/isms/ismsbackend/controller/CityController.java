package com.isms.ismsbackend.controller;

import com.isms.ismsbackend.entity.City;
import com.isms.ismsbackend.entity.ResultVO;
import com.isms.ismsbackend.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/28.
 * 地区控制层
 */
@RestController
@RequestMapping(value = "/city")
@CrossOrigin
public class CityController {
    
    @Autowired
    private CityService cityService;

    /**
     * 获取地区列表
     * @param page  当前页
     * @param limit 页大小
     * @return  封装的返回数据
     */
    @GetMapping("/cities/{page}/{limit}")
    public ResultVO getCityList(@PathVariable Integer page,@PathVariable Integer limit) {
        return cityService.queryAllCities(page, limit);
    }

    /**
     * 通过ID获取地区
     * @param cityId 地区ID
     * @return 封装的返回数据
     */
    @GetMapping("/{cityId}")
    public ResultVO getCityById(@PathVariable Integer cityId) {
        return cityService.queryById(cityId);
    }

    /**
     * 修改地区
     * @param city 地区对象
     * @return 封装的返回数据
     */
    @PutMapping("/city")
    public ResultVO modifyCity(@RequestBody City city) {
        return cityService.modifyCity(city);
    }

    /**
     * 新增地区
     * @param city 地区对象
     * @return 封装的返回数据
     */
    @PostMapping("/city")
    public ResultVO addCity(@RequestBody City city) {
        return cityService.addCity(city);
    }
    
    @GetMapping("/city/{cityName}")
    public Boolean existsName(@PathVariable String cityName) {
        return cityService.existsName(cityName);
    }
    
    @DeleteMapping("/city/{cityId}")
    public Boolean removeCity(@PathVariable Integer cityId) {
        return cityService.removeCity(cityId);
    }
    
}
