package com.agileboot.api.controller;

import com.agileboot.api.pojo.Result;
import com.agileboot.api.pojo.User;
import com.agileboot.api.service.UserService;
import com.agileboot.api.utils.JwtToken;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;
    @Autowired
    StringRedisTemplate redisTemplate;
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        userService.register(user);
        return new Result(200,"注册成功",null);
    }
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        System.out.println(user);
        JwtToken jwtToken=new JwtToken();
        if (userService.login(user)){
            String token = jwtToken.encode(userService.getInfo(user.getName()));
            ValueOperations<String, String> ops = redisTemplate.opsForValue();
            ops.set(token,token,4, TimeUnit.HOURS);
            return new Result(200,"登录成功",token);
        }else {
            return new Result(400,"账号或密码错误",null);
        }
    }
    @GetMapping("/info")
    public Result getInfo(@RequestHeader(name="Authorization") String token) {
        String name=userService.getUserName(token);
        return new Result(200,"获取成功",userService.getInfo(name));
    }
    @GetMapping("/getUserComment")
    public Result getUserComment(@RequestHeader(name="Authorization") String token) {
        Integer userId=userService.getUserId(token);
        return new Result(200,"获取成功",userService.getUserComment(userId));
    }
    @PostMapping("/commentDelete")
    public Result commentDelete(@RequestBody Map<String, Object> comment) {
        Integer commentId=Integer.parseInt(comment.get("id").toString());
        userService.delComment(commentId);
        return new Result(200,"删除成功",null);
    }
    @PostMapping("/replyDelete")
    public Result replyDelete(@RequestBody Map<String, Object> reply) {
        Integer replyId=Integer.parseInt(reply.get("id").toString());
        userService.delReply(replyId);
        return new Result(200,"删除成功",null);
    }
    @PostMapping("/confirmPwd")
    public Result confirmPwd(@RequestBody Map<String, Object> pwdInfo,@RequestHeader(name="Authorization") String token) {
        String pwd = pwdInfo.get("pwd").toString();
        return new Result(200,"验证成功",userService.confirmPwd(pwd, token));
    }
    @PostMapping("/updateUserInfo")
    public Result updateUserInfo(@RequestBody Map<String, Object> userInfo, HttpServletResponse response,@RequestHeader(name="Authorization") String token) {
        System.out.println("22222222222"+userInfo);
        if (userService.updateUserInfo(userInfo).equals("Pwd")){
            ValueOperations<String, String> ops = redisTemplate.opsForValue();
            ops.getOperations().delete(token);
            response.setStatus(401);
        }
        return new Result(200,"修改成功",null);
    }
    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam String avatarUrl, @RequestHeader(name="Authorization") String token) {
        Integer userId= userService.getUserId(token);
        userService.updateAvatar(avatarUrl, userId);
        return new Result(200,"修改成功",null);
    }
}
