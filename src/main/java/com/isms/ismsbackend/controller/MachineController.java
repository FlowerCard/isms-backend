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
public class MachineController {


    @Autowired
    private MachineService machineService;

    @Autowired
    private MachineTypeService machineTypeService;

    private ResultVO resultVO = null;

    @GetMapping("/findAll/{uId}/{page}/{limit}")
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

    @GetMapping("/findById/{mid}")
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


    @GetMapping("/findWorksiteNames")
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

    @PutMapping("/modifyMachine")
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

    @GetMapping("/existsName/{mname}")
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

    @DeleteMapping("/removeMachine/{mId}")
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

    @PostMapping("/addMachine")
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
