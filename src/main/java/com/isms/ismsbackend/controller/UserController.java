package com.isms.ismsbackend.controller;

import com.github.pagehelper.PageInfo;
import com.isms.ismsbackend.constant.MessageConstant;
import com.isms.ismsbackend.constant.ResponseCode;
import com.isms.ismsbackend.entity.ResultVO;
import com.isms.ismsbackend.entity.User;
import com.isms.ismsbackend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author lzj
 * @Date 2021/10/28
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
@Api(tags = "用户管理控制器",value = "提供了增删改查的handler，使用Restful风格发起访问")
public class UserController {

    @Autowired
    private UserService userService;

    private ResultVO resultVO = null;

    /**
     * 用户登录
     * @param user 登录参数对象
     * @return 封装的user对象
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录",notes ="根据登录参数查询,返回一个User对象" )
    @ApiImplicitParam(name = "user",dataType = "object",value = "User对象",example = "user",required = true)
    public ResultVO login(@RequestBody User user){
        //获取登录用户
        User findUser = userService.login(user);
        resultVO = new ResultVO();
        //用户对象不等于空
        if (null != findUser) {
            resultVO.setCode(ResponseCode.SUCCESS);
            resultVO.setMessage("登录成功！");
            resultVO.setData(findUser);
            return resultVO;
        }
        //用户对象等于空
        resultVO.setCode(0);
        return resultVO;
    }

    /**
     * 获取分页信息
     * @param page 当前页
     * @param limit 每页条数
     * @param fuzzy 输入框参数
     * @param uid 用户id
     * @return 封装的分页信息
     */
    @GetMapping("/findAll/{page}/{limit}")
    @ApiOperation(value = "分页查询用户数据",notes ="根据参数查询对应的User,返回一个User对象" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",dataType = "int",value = "当前页",example = "1",required = true),
            @ApiImplicitParam(name = "limit",dataType = "int",value = "每页条数",example = "10",required = true),
            @ApiImplicitParam(name = "fuzzy",dataType = "string",value = "输入框参数",example = "admin",required = true),
            @ApiImplicitParam(name = "uid",dataType = "int",value = "用户id",example = "2",required = true)
    })
    public ResultVO getUserList(@PathVariable Integer page, @PathVariable Integer limit,
                                String fuzzy,Integer uid){
        PageInfo pageInfo = userService.findAll(page, limit,fuzzy,uid);
        resultVO = new ResultVO();
        resultVO.setCode(ResponseCode.SUCCESS);
        resultVO.setMessage(MessageConstant.QUERY_SUCCESS);
        resultVO.setData(pageInfo);
        return resultVO;
    }

    /**
     * 根据用户id查询
     * @param uid 用户id
     * @return 封装的user对象
     */
    @GetMapping("findById/{uid}")
    @ApiOperation(value = "根据id查询对应的User",notes ="根据id查询对应的User,返回一个User对象" )
    @ApiImplicitParam(name = "uid",dataType = "int",value = "User对象的id",example = "2",required = true)
    public ResultVO findById(@PathVariable Integer uid){
        User user = userService.findById(uid);
        resultVO = new ResultVO();
        resultVO.setCode(ResponseCode.SUCCESS);
        resultVO.setMessage(MessageConstant.QUERY_SUCCESS);
        resultVO.setData(user);
        return resultVO;
    }


    /**
     * 校验用户名
     * @param userName 用户名
     * @return 封装的user对象
     */
    @GetMapping("/existsName/{userName}")
    @ApiOperation(value = "校验用户名",notes ="根据userName查询对应的User,返回一个User对象" )
    @ApiImplicitParam(name = "userName",dataType = "string",value = "用户名",example = "admin",required = true)
    public ResultVO existsName(@PathVariable String userName){
        User user = userService.existsName(userName);
        resultVO = new ResultVO();
        if(null != user){
            resultVO.setCode(ResponseCode.SUCCESS);
            return resultVO;
        }
        resultVO.setCode(ResponseCode.FAIL);
        return resultVO;
    }

    /**
     * 修改用户
     * @param user 修改的参数对象
     * @return 影响行数
     */
    @PutMapping("/modifyUser")
    @ApiOperation(value = "修改用户",notes ="根据user对象参数修改对应的User,返回一个User对象" )
    @ApiImplicitParam(name = "user",dataType = "object",value = "User对象",example = "user",required = true)
    public ResultVO modifyUser(@RequestBody User user){
        Integer integer = userService.modifyUserById(user);
        resultVO = new ResultVO();
        if (integer > 0) {
            resultVO.setCode(ResponseCode.SUCCESS);
            resultVO.setMessage(MessageConstant.UPDATE_SUCCESS);
            resultVO.setData(integer);
            return resultVO;
        }
        resultVO.setCode(ResponseCode.FAIL);
        return resultVO;
    }


    /**
     * 逻辑删除用户
     * @param uid 用户id
     * @return 影响行数
     */
    @DeleteMapping("/removeUserById/{uid}")
    @ApiOperation(value = "根据uid逻辑删除用户",notes ="根据uid修改对应的User,返回一个User对象" )
    @ApiImplicitParam(name = "uid",dataType = "int",value = "User对象的id",example = "2",required = true)
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

    /**
     * 新增用户
     * @param user 新增的用户数据对象
     * @return 封装的数据
     */
    @PostMapping("/addUser")
    @ApiOperation(value = "新增用户",notes ="返回一个User对象" )
    @ApiImplicitParam(name = "user",dataType = "object",value = "User对象",example = "user",required = true)
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
