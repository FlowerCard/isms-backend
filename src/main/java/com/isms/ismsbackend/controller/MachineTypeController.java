package com.isms.ismsbackend.controller;

import com.github.pagehelper.PageInfo;
import com.isms.ismsbackend.entity.ResultVO;
import com.isms.ismsbackend.service.MachineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lzj
 * @Date 2021/10/28
 * 商品类型控制层
 */
@RestController
@RequestMapping("/type")
public class MachineTypeController {
    @Autowired
    private MachineTypeService machineTypeService;

    @PostMapping("/findAll/{page}/{limit}")
    public ResultVO findAll(@PathVariable Integer page, @PathVariable Integer limit){
        PageInfo pageInfo = machineTypeService.findAll(page, limit);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMessage("查询类型成功！");
        resultVO.setData(pageInfo);
        return resultVO;
    }
}
