package com.isms.ismsbackend.controller;

import com.isms.ismsbackend.constant.MessageConstant;
import com.isms.ismsbackend.constant.ResponseCode;
import com.isms.ismsbackend.entity.ResultVO;
import com.isms.ismsbackend.entity.Worksite;
import com.isms.ismsbackend.service.WorksiteService;
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
 */
@RestController
@RequestMapping("/worksite")
@CrossOrigin
@Api(value = "提供查看工地列表，修改工地信息，删除工地，添加工地等功能", tags = "工地管理控制器")
public class WorksiteController {
    
    @Autowired
    private WorksiteService worksiteService;
    
    private ResultVO resultVO = null;

    /**
     * 查询工地列表
     * @param uid           用户ID
     * @param page          当前页
     * @param limit         页大小
     * @param searchName    工地名称
     * @param cityId        地区id
     * @return  封装的数据
     */
    @GetMapping("/worksites/{uid}/{page}/{limit}")
    @ApiOperation(value = "工地列表接口", notes = "通过登录的用户id，页码，页大小，模糊查询的参数，地区ID进行工地列表的查询")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "uid", value = "用户ID", required = true, example = "2"),
            @ApiImplicitParam(dataType = "int", name = "page", value = "当前页", required = true, example = "1"),
            @ApiImplicitParam(dataType = "int", name = "limit", value = "页大小", required = true, example = "10"),
            @ApiImplicitParam(dataType = "string", name = "searchName", value = "搜索的工地名称", required = true, example = "test"),
            @ApiImplicitParam(dataType = "int", name = "cityId", value = "地区ID", required = true, example = "1")
    })
    public ResultVO getWorksiteList(@PathVariable Integer uid, @PathVariable Integer page, 
                                    @PathVariable Integer limit, String searchName, Integer cityId) {
        return worksiteService.queryAll(uid, page, limit,searchName, cityId);
    }

    /**
     * 通过工地ID查询工地
     * @param cityId 工地ID
     * @return 封装的数据
     */
    @GetMapping("/{cityId}")
    @ApiOperation(value = "获取工地信息接口", notes = "通过传入的工地ID查询对应的工地信息")
    @ApiImplicitParam(dataType = "int", name = "cityId", value = "工地ID", required = true, example = "1")
    public ResultVO getWorksiteById(@PathVariable Integer cityId) {
        return worksiteService.queryWorksiteById(cityId);
    }

    /**
     * 校验名称是否存在
     * @param worksiteName 工地名称
     * @return 是否存在
     */
    @GetMapping("/worksite/{worksiteName}")
    @ApiOperation(value = "校验名称接口", notes = "通过传入的名称校验是否存在该名称，存在返回false，不存在返回true")
    @ApiImplicitParam(dataType = "string", name = "worksiteName", value = "工地名称", required = true, example = "test")
    public Boolean existsName(@PathVariable String worksiteName) {
        return worksiteService.existsName(worksiteName);
    }

    /**
     * 添加工地
     * @param worksite 工地对象
     * @return 封装的结果
     */
    @PostMapping("/worksite")
    @ApiOperation(value = "添加工地接口", notes = "通过传入的工地对象进行添加", produces = "application/json")
    @ApiImplicitParam(dataType = "object", name = "worksite", value = "工地对象", required = true)
    public ResultVO addWorksite(@RequestBody Worksite worksite) {
        resultVO = new ResultVO();
        if (worksite.getWorkName() == null || worksite.getWorkAddr() == null || worksite.getCityId() == null) {
            resultVO.setCode(ResponseCode.FAIL);
            resultVO.setMessage(MessageConstant.ADD_FAIL);
            resultVO.setData(null);
            return resultVO;
        }
        return worksiteService.addWorksite(worksite);
    }

    /**
     * 修改工地
     * @param worksite 工地对象
     * @return 封装的结果
     */
    @PutMapping("/worksite")
    @ApiOperation(value = "修改工地接口", notes = "通过传入的工地对象进行对应工地的修改", produces = "application/json")
    @ApiImplicitParam(dataType = "object", name = "worksite", value = "工地对象", required = true)
    public ResultVO modifyWorksite(@RequestBody Worksite worksite) {
        resultVO = new ResultVO();
        if (worksite.getWorkName() == null || worksite.getWorkAddr() == null || worksite.getCityId() == null) {
            resultVO.setCode(ResponseCode.FAIL);
            resultVO.setMessage(MessageConstant.ADD_FAIL);
            resultVO.setData(null);
            return resultVO;
        }
        return worksiteService.modifyWorksite(worksite);
    }

    /**
     * 删除工地
     * @param workId 工地ID
     * @return 封装的结果
     */
    @DeleteMapping("/{workId}")
    @ApiOperation(value = "删除工地接口", notes = "通过传入的工地ID进行工地的逻辑删除，如果工地下还有设备则无法删除")
    @ApiImplicitParam(dataType = "int", name = "workId", value = "工地ID", required = true)
    public ResultVO removeWorksite(@PathVariable Integer workId) {
        return worksiteService.removeWorksite(workId);
    }
    
}
