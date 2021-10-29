package com.isms.ismsbackend.controller;

import com.isms.ismsbackend.constant.MessageConstant;
import com.isms.ismsbackend.constant.ResponseCode;
import com.isms.ismsbackend.entity.ResultVO;
import com.isms.ismsbackend.entity.Worksite;
import com.isms.ismsbackend.service.WorksiteService;
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
public class WorksiteController {
    
    @Autowired
    private WorksiteService worksiteService;
    
    private ResultVO resultVO = null;
    
    @GetMapping("/worksites/{uid}/{page}/{limit}")
    public ResultVO getWorksiteList(@PathVariable Integer uid, @PathVariable Integer page, @PathVariable Integer limit) {
        return worksiteService.queryAll(uid, page, limit);
    }
    
    @GetMapping("/{id}")
    public ResultVO getWorksiteById(@PathVariable Integer id) {
        return worksiteService.queryWorksiteById(id);
    }
    
    @GetMapping("/worksite/{worksiteName}")
    public Boolean existsName(@PathVariable String worksiteName) {
        return worksiteService.existsName(worksiteName);
    }
    
    @PostMapping("/worksite")
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
    
    @PutMapping("/worksite")
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
    
}
