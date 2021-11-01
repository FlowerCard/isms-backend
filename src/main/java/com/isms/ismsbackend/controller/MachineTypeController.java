package com.isms.ismsbackend.controller;

import com.github.pagehelper.PageInfo;
import com.isms.ismsbackend.constant.MessageConstant;
import com.isms.ismsbackend.constant.ResponseCode;
import com.isms.ismsbackend.entity.MachineType;
import com.isms.ismsbackend.entity.ResultVO;
import com.isms.ismsbackend.service.MachineTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author lzj
 * @Date 2021/10/28
 * 商品类型控制层
 */
@RestController
@RequestMapping("/type")
@CrossOrigin
@Api(tags = "设备类型管理控制器",value = "提供了增删改查的handler，使用Restful风格发起访问")
public class MachineTypeController {
    @Autowired
    private MachineTypeService machineTypeService;

    private ResultVO resultVO = null;

    /**
     * 获取分页信息
     * @param page 当前页
     * @param limit 每页条数
     * @param typeId 设备类型id
     * @return 封装的分页信息
     */
    @GetMapping("/findAll/{page}/{limit}")
    @ApiOperation(value = "分页查询设备类型数据",notes ="根据参数查询对应的MachineType,返回一个MachineType对象" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",dataType = "int",value = "当前页",example = "1",required = true),
            @ApiImplicitParam(name = "limit",dataType = "int",value = "每页条数",example = "10",required = true),
            @ApiImplicitParam(name = "typeId",dataType = "int",value = "设备类型id",example = "1",required = true)
    })
    public ResultVO findAll(@PathVariable Integer page, @PathVariable Integer limit,
                            Integer typeId){
        PageInfo pageInfo = machineTypeService.findAll(page, limit,typeId);
        resultVO = new ResultVO();
        resultVO.setCode(ResponseCode.SUCCESS);
        resultVO.setMessage(MessageConstant.QUERY_SUCCESS);
        resultVO.setData(pageInfo);
        return resultVO;
    }

    /**
     * 根据id查询
     * @param typeId 设备类型id
     * @return ResultVO
     */
    @GetMapping("/findById/{typeId}")
    @ApiOperation(value = "根据设备类型id查询对应的machineType对象",notes ="返回一个machineType对象" )
    @ApiImplicitParam(name = "typeId",dataType = "int",value = "设备类型id",example = "2",required = true)
    public ResultVO findByTypeId(@PathVariable Integer typeId){
        MachineType machineType = machineTypeService.findById(typeId);
        resultVO = new ResultVO();
        if (null != machineType) {
            resultVO.setCode(ResponseCode.SUCCESS);
            resultVO.setMessage(MessageConstant.QUERY_SUCCESS);
            resultVO.setData(machineType);
            return resultVO;
        }
        resultVO.setCode(ResponseCode.FAIL);
        return resultVO;
    }

    /**
     * 校验设备类型名
     * @param typeName 设备类型名称
     * @return ResultVO
     */
    @GetMapping("/existsName/{typeName}")
    @ApiOperation(value = "校验设备类型名",notes ="根据typeName查询对应的MachineType,返回一个MachineType对象" )
    @ApiImplicitParam(name = "typeName",dataType = "string",value = "设备类型名称",example = "考勤设备",required = true)
    public ResultVO existsName(@PathVariable String typeName){
        MachineType machineType = machineTypeService.existsName(typeName);
        if (null != machineType) {
            resultVO.setCode(ResponseCode.SUCCESS);
            return resultVO;
        }
        resultVO.setCode(ResponseCode.FAIL);
        return resultVO;
    }

    /**
     * 修改设备类型
     * @param machineType 封装修改参数的对象
     * @return ResultVO
     */
    @PutMapping("/modifyMachineType")
    @ApiOperation(value = "修改设备类型",notes ="根据machineType对象参数修改对应的machineType,返回一个machineType对象" )
    @ApiImplicitParam(name = "machineType",dataType = "object",value = "machineType对象",example = "machineType",required = true)
    public ResultVO modifyMachineType (@RequestBody MachineType machineType){
        Integer integer = machineTypeService.modifyMachineType(machineType);
        resultVO = new ResultVO();
        if (integer > 0) {
            resultVO.setCode(ResponseCode.SUCCESS);
            resultVO.setMessage(MessageConstant.UPDATE_SUCCESS);
            return resultVO;
        }
        resultVO.setCode(ResponseCode.FAIL);
        return resultVO;
    }


    /**
     * 逻辑删除
     * @param typeId
     * @return
     */
    @DeleteMapping("/removeMachineType/{typeId}")
    @ApiOperation(value = "逻辑删除,根据设备类型id修改对应的设备类型对象",notes ="返回一个machineType对象" )
    @ApiImplicitParam(name = "typeId",dataType = "int",value = "设备类型id",example = "2",required = true)
    public ResultVO removeMachineType(@PathVariable Integer typeId){
        Integer integer = machineTypeService.updateMachineType(typeId);
        resultVO = new ResultVO();
        if (integer > 0) {
            resultVO.setCode(ResponseCode.SUCCESS);
            resultVO.setMessage(MessageConstant.DELETE_SUCCESS);
            return resultVO;
        }
        resultVO.setCode(ResponseCode.FAIL);
        return resultVO;
    }

    /**
     * 根据id查询设备类型名称
     * @param typeId
     * @return
     */
    @PostMapping("/typeId/{typeId}")
    @ApiOperation(value = "根据id查询设备类型名称",notes ="返回一个machineType对象" )
    @ApiImplicitParam(name = "typeId",dataType = "int",value = "设备类型id",example = "2",required = true)
    public ResultVO getTypeNameByTypeId(@PathVariable Integer typeId){
        List<MachineType> machineType = machineTypeService.findByTypeId(typeId);
        resultVO.setCode(ResponseCode.SUCCESS);
        resultVO.setData(machineType);
        return resultVO;
    }

    /**
     * 新增设备类型
     * @param machineType 封装新增信息的对象
     * @return ResultVO
     */
    @PostMapping("/addMachineType")
    @ApiOperation(value = "新增设备类型",notes ="返回一个machineType对象" )
    @ApiImplicitParam(name = "machineType",dataType = "object",value = "machineType对象",example = "machineType",required = true)
    public ResultVO addMachineType(@RequestBody MachineType machineType){
        Integer integer = machineTypeService.addMachineType(machineType);
        resultVO = new ResultVO();
        if (integer > 0) {
            resultVO.setCode(ResponseCode.SUCCESS);
            resultVO.setMessage(MessageConstant.ADD_SUCCESS);
            return resultVO;
        }
        resultVO.setCode(ResponseCode.FAIL);
        return resultVO;
    }
}
