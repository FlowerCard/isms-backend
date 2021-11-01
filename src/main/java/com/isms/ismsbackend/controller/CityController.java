package com.isms.ismsbackend.controller;

import com.isms.ismsbackend.entity.City;
import com.isms.ismsbackend.entity.ResultVO;
import com.isms.ismsbackend.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "地区管理控制器", value = "提供查看地区列表，修改地区信息，删除地区，添加地区等功能")
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
    @ApiOperation(value = "分页获取地区列表接口", notes = "通过页码，页大小，模糊查询的参数，地区ID进行工地列表的查询")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "page", value = "当前页", required = true, example = "1"),
            @ApiImplicitParam(dataType = "int", name = "limit", value = "页大小", required = true, example = "10"),
            @ApiImplicitParam(dataType = "string", name = "searchName", value = "搜索的工地名称", required = true, example = "test"),
            @ApiImplicitParam(dataType = "int", name = "cityId", value = "地区ID", required = true, example = "1")
    })
    public ResultVO getCityList(@PathVariable Integer page,@PathVariable Integer limit, String searchName, Integer cityId) {
        return cityService.queryAllCities(page, limit, searchName, cityId);
    }

    /**
     * 不分页获取地区列表
     * @return 封装的返回数据
     */
    @GetMapping("/cities")
    @ApiOperation(value = "不分页获取地区列表接口")
    public ResultVO getCityList() {
        return cityService.queryAllCities();
    }

    /**
     * 通过ID获取地区
     * @param cityId 地区ID
     * @return 封装的返回数据
     */
    @GetMapping("/{cityId}")
    @ApiOperation(value = "查询地区信息接口", notes = "通过传入的地区ID查询对应的地区信息")
    @ApiImplicitParam(dataType = "int", name = "cityId", value = "地区ID", required = true, example = "1")
    public ResultVO getCityById(@PathVariable Integer cityId) {
        return cityService.queryById(cityId);
    }

    /**
     * 修改地区
     * @param city 地区对象
     * @return 封装的返回数据
     */
    @PutMapping("/city")
    @ApiOperation(value = "修改地区接口", notes = "通过传入的地区对象，对对应的地区信息进行修改", produces = "application/json")
    @ApiImplicitParam(dataType = "object", name = "city", value = "地区对象", required = true)
    public ResultVO modifyCity(@RequestBody City city) {
        return cityService.modifyCity(city);
    }

    /**
     * 新增地区
     * @param city 地区对象
     * @return 封装的返回数据
     */
    @PostMapping("/city")
    @ApiOperation(value = "添加地区接口", notes = "通过传入的地区对象进行地区的添加", produces = "application/json")
    @ApiImplicitParam(dataType = "object", name = "city", value = "地区对象", required = true)
    public ResultVO addCity(@RequestBody City city) {
        return cityService.addCity(city);
    }

    /**
     * 校验名称是否存在
     * @param cityName 地区名称
     * @return 是否存在
     */
    @GetMapping("/city/{cityName}")
    @ApiOperation(value = "校验名称接口", notes = "通过传入的地区名称，校验名称是否存在")
    @ApiImplicitParam(dataType = "string", name = "cityName", value = "地区名称", required = true)
    public Boolean existsName(@PathVariable String cityName) {
        return cityService.existsName(cityName);
    }

    /**
     * 删除地区
     * @param cityId 地区ID
     * @return 是否成功
     */
    @DeleteMapping("/city/{cityId}")
    @ApiOperation(value = "删除地区接口", notes = "通过传入的地区ID进行对应地区的删除，如果被删除的地区下还有工地则无法删除")
    public Boolean removeCity(@PathVariable Integer cityId) {
        return cityService.removeCity(cityId);
    }
    
}
