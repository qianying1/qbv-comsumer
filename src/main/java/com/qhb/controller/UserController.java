package com.qhb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qhb.core.redis.RedisUtil;
import com.qhb.model.User;
import com.qhb.service.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

@Api(value = "UserController", description = "用户模块接口")
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Reference(version = "1.0.0")
    private UserService userService;
    @Resource(name = "redisUtil")
    private RedisUtil redisUtil;

    @ApiOperation(value="添加用户", notes="添加用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名",paramType ="form", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码",paramType = "form",required = true ,dataType = "string"),
            @ApiImplicitParam(name="phone",value="手机号",paramType = "form",required = true,dataType = "string")
    })
    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    public int addUser(User user) {
        /*try {
            for (int i = 0; i < 10; i++) {
                redisUtil.set("hello" + i, "hello world" + i);
            }
            for (int i = 0; i < 10; i++) {
                String test = (String) redisUtil.get("hello" + i);
                logger.info("控制层设置hello" + i + "的值为：>>>>>>>>>>>>>>>>" + test);
            }
        } catch (Exception e) {
            logger.error("fail to write/read data in redis client!", e);
        }*/
        return userService.addUser(user);
    }

    @ApiOperation(value="分页获取所有用户信息", notes="获取用户信息接口")
    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public Object findAllUser(@PathVariable("pageNum") @ApiParam(name="pageNum",type = "int",defaultValue = "1") int pageNum,@PathVariable("pageSize") @ApiParam(name="pageSize",type="int",defaultValue = "15") int pageSize) {

        return userService.findAllUser(pageNum, pageSize);
    }

    @ApiOperation(value="获取某个用户信息", notes="获取用户信息接口")
    @ResponseBody
    @RequestMapping(value = "/user/{userId}", produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public Object selectByPrimaryKey(@PathVariable("userId") @ApiParam(name="userId",required = true) Integer userId) {

        return userService.selectByPrimaryKey(userId);
    }
}
