package com.zjitc.lostandfound_api.controller;

import com.zjitc.lostandfound_api.pojo.Result;
import com.zjitc.lostandfound_api.pojo.User;
import com.zjitc.lostandfound_api.service.AdminService;
import com.zjitc.lostandfound_api.service.UserService;
import com.zjitc.lostandfound_api.utils.JwtToken;
import io.lettuce.core.ScriptOutputType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private UserService userService;
    @Resource
    private AdminService adminService;
    @Autowired
    StringRedisTemplate redisTemplate;
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        JwtToken jwtToken=new JwtToken();
        System.out.println("222222222"+user.toString());
        Integer isAdmin = adminService.login(user);
        if (isAdmin == 1){
            System.out.println(1);
            String token = jwtToken.encode(userService.getInfo(user.getName()));
            ValueOperations<String, String> ops = redisTemplate.opsForValue();
            ops.set(token,token,4, TimeUnit.HOURS);
            Map<String, String> data = new HashMap<>();
            data.put("token", token);
            return new Result(200,"登录成功",data);
        }else if (isAdmin == 2){
            System.out.println(2);
            return new Result(400,"不是管理员无权登录",null);
        }else{
            System.out.println(isAdmin);
            return new Result(400,"账号或密码错误",null);
        }
    }
    @GetMapping("/info")
    public Result getInfo(@RequestHeader(name="Authorization") String token){
        User user = userService.getInfo(userService.getUserName(token));
        Map<String, Object> data = new HashMap<>();
        List<String> roles = Arrays.asList("admin");
        data.put("name", user.getName());
        data.put("avatar", user.getAvatar());
        data.put("roles", roles);
        return new Result(200,"获取成功",data);
    }
    @PostMapping("/get_menu_list")
    public Result getMenuList(){
        return new Result(200,"获取成功","0");
    }

    @GetMapping("/getAllUser")
    public Result getAllUser(){
        return new Result(200,"获取成功",adminService.getAllUser());
    }

    @PostMapping("/delUsers")
    public Result deleteUsers(@RequestBody List<Integer> ids) {
        System.out.println("deleteUsers: " + ids);
        boolean result = adminService.deleteUsers(ids);
        if (result) {
            return new Result(200, "删除成功", true);
        } else {
            return new Result(500, "删除失败", false);
        }
    }

    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody User user){
        System.out.println("params: "+user);
        return new Result(200,"修改成功", adminService.updateUser(user));
//        return new Result(200,"修改成功", true);
    }

    @PostMapping("/newUser")
    public Result newUser(@RequestBody User user){
        System.out.println("user: "+user);
        return new Result(200,"添加成功", adminService.newUser(user));
    }

    @PostMapping("/prohibit")
    public Result prohibit(@RequestBody Map<String, Object> params){
        System.out.println("params: "+params);
        return new Result(200,"修改成功", adminService.prohibit(params));
    }
    @PostMapping("/resetPwd/{id}")
    public Result resetPwd(@PathVariable Integer id){
        return new Result(200,"修改成功", userService.resetPwd(id));
    }

    @GetMapping("/getUserByParams")
    public Result getUserByParams(@RequestParam(required = false) String username,
                                  @RequestParam(required = false) String phone){
        List<User> userList = adminService.getUserByParams(username, phone);
        System.out.println(userList);
        return new Result(200,"获取成功", userList);
    }

    @GetMapping("/commentList")
    public Result commentList(){
        return new Result(200,"获取成功", adminService.getAllComment());
    }
    @PostMapping("/deleteComment")
    public Result deleteComment(@RequestBody List<Integer> ids){
        System.out.println("deleteComment: " + ids);
        return new Result(200,"删除成功", adminService.deleteComments(ids));
    }
    @PostMapping("/deleteReply")
    public Result deleteReply(@RequestBody List<Integer> ids){
        System.out.println("deleteReply: " + ids);
        return new Result(200,"删除成功", adminService.deleteReplys(ids));
    }

    @GetMapping("/getAllNotice")
    public Result getAllNotice(){
        return new Result(200,"获取成功", adminService.getAllNotice());
    }
    @PostMapping("/delNotice")
    public Result deleteNotice(@RequestBody List<Integer> ids){
        System.out.println("deleteNotice: " + ids);
        return new Result(200,"删除成功", adminService.deleteNotice(ids));
    }
    @GetMapping("/getCategory")
    public Result getCategory(){
        return new Result(200,"获取成功", adminService.findCategory());
    }
}
