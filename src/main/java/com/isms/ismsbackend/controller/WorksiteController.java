package com.isms.ismsbackend.controller;

import com.isms.ismsbackend.entity.ResultVO;
import com.isms.ismsbackend.service.WorksiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/28.
 */
@RestController
@RequestMapping("/worksite")
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
    
}
