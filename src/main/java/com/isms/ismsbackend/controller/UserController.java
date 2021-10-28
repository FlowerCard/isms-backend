package com.isms.ismsbackend.controller;

import com.github.pagehelper.PageInfo;
import com.isms.ismsbackend.entity.ResultVO;
import com.isms.ismsbackend.entity.User;
import com.isms.ismsbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author lzj
 * @Date 2021/10/28
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    private ResultVO resultVO = null;

    @PostMapping("/login")
    public ResultVO login(@RequestBody User user){
            System.out.println(user);
        User user1 = userService.login(user);
        resultVO = new ResultVO();
        if (null != user1) {
            resultVO.setCode(1);
            resultVO.setMessage("登录成功！");
            resultVO.setData(user1);
            return resultVO;
        }
        resultVO.setCode(0);
        return resultVO;
    }

    @GetMapping("/findAll/{page}/{limit}")
    public ResultVO getUserList(@PathVariable Integer page, @PathVariable Integer limit){
        PageInfo pageInfo = userService.findAll(page, limit);
        resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMessage("查询成功！");
        resultVO.setData(pageInfo);
        return resultVO;
    }

    @GetMapping("findById/{uid}")
    public ResultVO findById(@PathVariable Integer uid){
        User user = userService.findById(uid);
        resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMessage("查询成功");
        resultVO.setData(user);
        return resultVO;
    }


    @GetMapping("/existsName/{userName}")
    public ResultVO existsName(@PathVariable String userName){
        User user = userService.existsName(userName);
        resultVO = new ResultVO();
        if(null != user){
            resultVO.setCode(1);
            return resultVO;
        }
        resultVO.setCode(0);
        return resultVO;
    }

    @PutMapping("/modifyUser")
    public ResultVO modifyUser(@RequestBody User user){
        Integer integer = userService.modifyUserById(user);
        resultVO = new ResultVO();
        if (integer > 0) {
            resultVO.setCode(1);
            resultVO.setMessage("修改成功");
            resultVO.setData(integer);
            return resultVO;
        }
        resultVO.setCode(0);
        return resultVO;
    }


    @DeleteMapping("/removeUserById/{uid}")
    public ResultVO removeUser(@PathVariable Integer uid){
        Integer integer = userService.removeUserById(uid);
        resultVO = new ResultVO();
        if (integer > 0) {
            resultVO.setCode(1);
            resultVO.setMessage("删除成功");
            resultVO.setData(integer);
            return resultVO;
        }
        resultVO.setCode(0);
        return resultVO;
    }

    @PostMapping("/addUser")
    public ResultVO addUser(@RequestBody User user){
        Integer integer = userService.addUser(user);
        resultVO = new ResultVO();
        if (integer > 0) {
            resultVO.setCode(1);
            resultVO.setMessage("添加成功~");
            return resultVO;
        }
        resultVO.setCode(0);
        return resultVO;
    }

}
