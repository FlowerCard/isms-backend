package com.isms.ismsbackend.controller;

import com.github.pagehelper.PageInfo;
import com.isms.ismsbackend.constant.MessageConstant;
import com.isms.ismsbackend.constant.ResponseCode;
import com.isms.ismsbackend.entity.Machine;
import com.isms.ismsbackend.entity.MachineType;
import com.isms.ismsbackend.entity.ResultVO;
import com.isms.ismsbackend.entity.Worksite;
import com.isms.ismsbackend.service.MachineService;
import com.isms.ismsbackend.service.MachineTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author lzj
 * @Date 2021/10/29
 * 设备业务层
 */
@RestController
@RequestMapping("/machine")
@CrossOrigin
@Api(tags = "设备管理控制器",value = "提供了增删改查的handler，使用Restful风格发起访问")
public class MachineController {


    @Autowired
    private MachineService machineService;

    @Autowired
    private MachineTypeService machineTypeService;

    private ResultVO resultVO = null;

    /**
     * 根据条件查询所有
     * @param uId 用户id
     * @param fuzzy 输入框的值
     * @param typeId 设备类型id
     * @param workId 工地id
     * @return Machine集合
     */
    @GetMapping("/findAll/{uId}/{page}/{limit}")
    @ApiOperation(value = "分页查询设备类型数据",notes ="根据参数查询对应的MachineType,返回一个MachineType对象" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",dataType = "int",value = "当前页",example = "1",required = true),
            @ApiImplicitParam(name = "limit",dataType = "int",value = "每页条数",example = "10",required = true),
            @ApiImplicitParam(name = "typeId",dataType = "int",value = "设备类型id",example = "1",required = true),
            @ApiImplicitParam(name = "uId",dataType = "int",value = "用户id",example = "2",required = true),
            @ApiImplicitParam(name = "workId",dataType = "int",value = "工地id",example = "1",required = true),
            @ApiImplicitParam(name = "fuzzy",dataType = "string",value = "输入框的值",example = "大运汽车",required = true)
    })
    public ResultVO getMachineList(@PathVariable Integer uId, @PathVariable Integer page,
                                   @PathVariable Integer limit, String fuzzy,
                                   Integer typeId,Integer workId){
        PageInfo pageInfo = machineService.findAll(uId, page, limit,fuzzy,typeId,workId);
        resultVO = new ResultVO();
        if (null != pageInfo) {
            resultVO.setCode(ResponseCode.SUCCESS);
            resultVO.setMessage(MessageConstant.QUERY_SUCCESS);
            resultVO.setData(pageInfo);
            return resultVO;
        }
        resultVO.setCode(ResponseCode.FAIL);
        resultVO.setMessage(MessageConstant.QUERY_FAIL);
        return resultVO;
    }

    /**
     * 根据id查询
     * @param mid 设备id
     * @return Machine
     */
    @GetMapping("/findById/{mid}")
    @ApiOperation(value = "根据设备id查询对应的machine对象",notes ="返回一个machine对象" )
    @ApiImplicitParam(name = "mid",dataType = "int",value = "设备id",example = "2",required = true)
    public ResultVO getMachineListById(@PathVariable Integer mid){
        Machine machine = machineService.findById(mid);
        resultVO = new ResultVO();
        if (null != machine) {
            resultVO.setCode(ResponseCode.SUCCESS);
            resultVO.setMessage(MessageConstant.QUERY_SUCCESS);
            resultVO.setData(machine);
            return resultVO;
        }
        resultVO.setCode(ResponseCode.FAIL);
        resultVO.setMessage(MessageConstant.QUERY_FAIL);
        return resultVO;
    }

    /**
     * 查询所有设备名称
     * @return
     */
    @GetMapping("/findTypeName")
    @ApiOperation(value = "查询所有设备名称",notes ="返回一个machine集合对象" )
    public ResultVO findTypeNames(){
        List<MachineType> machineTypeNames = machineTypeService.findMachineTypeNames();
        resultVO = new ResultVO();
        if (machineTypeNames.size() > 0) {
            resultVO.setCode(ResponseCode.SUCCESS);
            resultVO.setMessage(MessageConstant.QUERY_SUCCESS);
            resultVO.setData(machineTypeNames);
            return resultVO;
        }
        resultVO.setCode(ResponseCode.FAIL);
        return resultVO;
    }

    /**
     * 获取所有工地名称
     * @return
     */
    @GetMapping("/findWorksiteNames")
    @ApiOperation(value = "获取所有工地名称",notes ="返回一个Worksite集合对象" )
    public ResultVO findWorksiteNames(){
        List<Worksite> worksiteNameByUid = machineService.findWorksiteNames();
        resultVO = new ResultVO();
        if (worksiteNameByUid.size() > 0) {
            resultVO.setCode(ResponseCode.SUCCESS);
            resultVO.setMessage(MessageConstant.QUERY_SUCCESS);
            resultVO.setData(worksiteNameByUid);
            return resultVO;
        }
        resultVO.setCode(ResponseCode.FAIL);
        return resultVO;
    }

    /**
     * 修改设备
     * @param machine 封装修改数据的对象
     * @return ResultVO
     */
    @PutMapping("/modifyMachine")
    @ApiOperation(value = "修改设备",notes ="ResultVO" )
    @ApiImplicitParam(name = "machine",dataType = "object",value = "封装修改数据的对象",example = "machine",required = true)
    public ResultVO modifyMachine(@RequestBody Machine machine){
        machine.setUpdateDate(new Date());
        Integer integer = machineService.modifyMachine(machine);
        resultVO = new ResultVO();
        if (integer > 0) {
            resultVO.setCode(ResponseCode.SUCCESS);
            resultVO.setMessage(MessageConstant.UPDATE_SUCCESS);
            return resultVO;
        }
        resultVO.setCode(ResponseCode.FAIL);
        resultVO.setMessage(MessageConstant.UPDATE_FAIL);
        return resultVO;
    }

    /**
     * 校验设备名称
     * @param mname 设备名称
     * @return ResultVO
     */
    @GetMapping("/existsName/{mname}")
    @ApiOperation(value = "校验设备名称",notes ="ResultVO" )
    @ApiImplicitParam(name = "mname",dataType = "string",value = "设备名称",example = "大运汽车",required = true)
    public ResultVO existsName(@PathVariable String mname){
        Machine machine = machineService.existsName(mname);
        resultVO = new ResultVO();
        if (null != machine) {
            resultVO.setCode(ResponseCode.SUCCESS);
            return resultVO;
        }
        resultVO.setCode(ResponseCode.FAIL);
        return resultVO;
    }

    /**
     * 逻辑删除
     * @param mId 设备id
     * @return ResultVO
     */
    @DeleteMapping("/removeMachine/{mId}")
    @ApiOperation(value = "逻辑删除",notes ="ResultVO" )
    @ApiImplicitParam(name = "mId",dataType = "int",value = "设备id",example = "1",required = true)
    public ResultVO removeMachine(@PathVariable Integer mId){
        Integer integer = machineService.removeMachine(mId);
        resultVO = new ResultVO();
        if (integer > 0) {
            resultVO.setCode(ResponseCode.SUCCESS);
            resultVO.setMessage(MessageConstant.DELETE_SUCCESS);
            return resultVO;
        }
        resultVO.setCode(ResponseCode.FAIL);
        resultVO.setMessage(MessageConstant.DELETE_FAIL);
        return resultVO;
    }

    /**
     * 新增设备
     * @param machine 封装新增
     * @return
     */
    @PostMapping("/addMachine")
    @ApiOperation(value = "新增设备",notes ="ResultVO" )
    @ApiImplicitParam(name = "machine",dataType = "object",value = "封装新增",example = "machine",required = true)
    public ResultVO addMachine(@RequestBody Machine machine){
        machine.setCreateDate(new Date());
        machine.setUpdateDate(new Date());
        Integer integer = machineService.addMachine(machine);
        resultVO = new ResultVO();
        if (integer > 0) {
            resultVO.setCode(ResponseCode.SUCCESS);
            resultVO.setMessage(MessageConstant.ADD_SUCCESS);
            return resultVO;
        }
        resultVO.setCode(ResponseCode.FAIL);
        resultVO.setMessage(MessageConstant.ADD_FAIL);
        return resultVO;
    }
}
