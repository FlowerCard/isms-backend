package com.isms.ismsbackend.controller;

import com.github.pagehelper.PageInfo;
import com.isms.ismsbackend.constant.MessageConstant;
import com.isms.ismsbackend.constant.ResponseCode;
import com.isms.ismsbackend.entity.Machine;
import com.isms.ismsbackend.entity.MachineType;
import com.isms.ismsbackend.entity.ResultVO;
import com.isms.ismsbackend.service.MachineService;
import com.isms.ismsbackend.service.MachineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResultVO getMachineList(@PathVariable Integer uId, @PathVariable Integer page, @PathVariable Integer limit){
        PageInfo pageInfo = machineService.findAll(uId, page, limit);
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
}
