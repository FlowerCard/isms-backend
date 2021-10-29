package com.isms.ismsbackend.controller;

import com.github.pagehelper.PageInfo;
import com.isms.ismsbackend.entity.MachineType;
import com.isms.ismsbackend.entity.ResultVO;
import com.isms.ismsbackend.service.MachineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author lzj
 * @Date 2021/10/28
 * 商品类型控制层
 */
@RestController
@RequestMapping("/type")
@CrossOrigin
public class MachineTypeController {
    @Autowired
    private MachineTypeService machineTypeService;

    private ResultVO resultVO = null;

    @GetMapping("/findAll/{page}/{limit}")
    public ResultVO findAll(@PathVariable Integer page, @PathVariable Integer limit,
                            Integer typeId){
        PageInfo pageInfo = machineTypeService.findAll(page, limit,typeId);
        resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMessage("查询类型成功！");
        resultVO.setData(pageInfo);
        return resultVO;
    }

    @GetMapping("/findById/{typeId}")
    public ResultVO findByTypeId(@PathVariable Integer typeId){
        MachineType machineType = machineTypeService.findById(typeId);
        resultVO = new ResultVO();
        if (null != machineType) {
            resultVO.setCode(1);
            resultVO.setMessage("查询成功");
            resultVO.setData(machineType);
            return resultVO;
        }
        resultVO.setCode(0);
        return resultVO;
    }

    @GetMapping("/existsName/{typeName}")
    public ResultVO existsName(@PathVariable String typeName){
        MachineType machineType = machineTypeService.existsName(typeName);
        if (null != machineType) {
            resultVO.setCode(1);
            return resultVO;
        }
        resultVO.setCode(0);
        return resultVO;
    }

    @PutMapping("/modifyMachineType")
    public ResultVO modifyMachineType (@RequestBody MachineType machineType){
        Integer integer = machineTypeService.modifyMachineType(machineType);
        resultVO = new ResultVO();
        if (integer > 0) {
            resultVO.setCode(1);
            resultVO.setMessage("修改成功");
            return resultVO;
        }
        resultVO.setCode(0);
        return resultVO;
    }


    @DeleteMapping("/removeMachineType/{typeId}")
    public ResultVO removeMachineType(@PathVariable Integer typeId){
        Integer integer = machineTypeService.updateMachineType(typeId);
        resultVO = new ResultVO();
        if (integer > 0) {
            resultVO.setCode(1);
            resultVO.setMessage("删除成功");
            return resultVO;
        }
        resultVO.setCode(0);
        return resultVO;
    }

    @PostMapping("/typeId/{typeId}")
    public ResultVO findByTypeId1(@PathVariable Integer typeId){
        MachineType machineType = machineTypeService.findByTypeId(typeId);
        resultVO.setCode(1);
        resultVO.setData(machineType);
        return resultVO;
    }

    @PostMapping("/addMachineType")
    public ResultVO addMachineType(@RequestBody MachineType machineType){
        Integer integer = machineTypeService.addMachineType(machineType);
        resultVO = new ResultVO();
        if (integer > 0) {
            resultVO.setCode(1);
            resultVO.setMessage("新增成功");
            return resultVO;
        }
        resultVO.setCode(0);
        return resultVO;
    }
}
