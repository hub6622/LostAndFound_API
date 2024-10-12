package com.agileboot.api.controller;

import com.agileboot.api.pojo.Result;
import com.agileboot.api.service.ItemService; // 修改了service的名字
import com.agileboot.api.service.UserService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/item") // 修改了控制器的根路径
public class ItemController { // 控制器类名也做了相应的修改
    @Resource
    ItemService itemService; // 服务对象名称修改
    @Resource
    UserService userService;

    @GetMapping("/list")
    public Result getAll(){
        System.out.println("get all");
        return new Result(200, "success", itemService.findAll()); // 服务方法名修改
    }
    @GetMapping("/newestList")
    public Result getNewestList(){
        System.out.println("getNewestList");
        return new Result(200, "success", itemService.findNewest());
    }
    @GetMapping("/getItemById/{id}")
    public Result getItemById(@PathVariable Integer id){ // 方法名修改
        System.out.println("getItemById");
        return new Result(200, "success", itemService.getById(id)); // 服务方法名修改
    }

    @GetMapping("/getItemByCategory/{category}")
    public Result getItemByCategory(@PathVariable String category){ // 方法名修改
        System.out.println("getItemByCategory" + itemService.findByCategory(category)); // 服务方法名修改
        return new Result(200, "success", itemService.findByCategory(category)); // 服务方法名修改
    }

    @GetMapping("/getCategory")
    public Result getCategory(){
        System.out.println("getItemById"); // 这里原逻辑似乎有误，保留了原样
        return new Result(200, "success", itemService.findCategory()); // 服务方法名修改
    }

    @GetMapping("/commentsByItemId/{id}") // 方法名修改
    public Result getCommentsByItemId(@PathVariable Integer id){ // 方法名修改
        System.out.println("getCommentsByItemId");
        return new Result(200, "success", itemService.getCommentsByItemId(id)); // 服务方法名修改
    }

    @PostMapping("/addItemComment")
    public Result addItemComment(@RequestBody Map<String, Object> comment, @RequestHeader(name="Authorization") String token){ // 方法名修改
        System.out.println("addItemComment");
        String content = comment.get("content").toString();
        Integer itemId = Integer.parseInt(comment.get("itemId").toString()); // 字段名修改
        itemService.updateItemCommentCounts(itemId); // 服务方法名修改
        String name = userService.getUserName(token);
        itemService.addComment(name, content, itemId); // 服务方法名修改
        return new Result(200, "success", null);
    }

    @PostMapping("/addItemCommentReply")
    public Result addItemCommentReply(@RequestBody Map<String, Object> comment, @RequestHeader(name="Authorization") String token){ // 方法名修改
        System.out.println(comment.get("content") + "===" + comment.get("commentId"));
        String content = comment.get("content").toString();
        Integer commentId = Integer.parseInt(comment.get("commentId").toString());
        itemService.updateItemCommentCounts(commentId); // 服务方法名修改
        String name = userService.getUserName(token);
        itemService.addCommentReply(name, content, commentId); // 服务方法名修改
        return new Result(200, "success", null);
    }

    @PostMapping("/addItem")
    public Result addItem(@RequestBody Map<String, Object> item, @RequestHeader(name="Authorization") String token){ // 方法名修改
        System.out.println(item.get("content") + "===" + item.get("title") + "===" + item.get("category"));
        String name = userService.getUserName(token);
        itemService.addItem(name, item); // 服务方法名修改
        return new Result(200, "success", null);
    }

    @PostMapping("/updateItemViewCounts/{itemId}") // 方法名修改
    public Result updateItemViewCounts(@PathVariable Integer itemId){ // 方法名修改
        System.out.println("updateItem");
        itemService.updateItemViewCounts(itemId); // 服务方法名修改
        return new Result(200, "success", null);
    }

    @GetMapping("/hotItem") // 方法名修改
    public Result hotItem(){ // 方法名修改
        System.out.println("hotItem");
        return new Result(200, "success", itemService.findItemByViews()); // 服务方法名修改
    }

    @GetMapping("/getItemByUser")
    public Result getItemByUser(@RequestHeader(name="Authorization") String token){ // 方法名修改
        System.out.println("getItemByUser");
        Integer userId = userService.getUserId(token);
        return new Result(200, "success", itemService.findByUser(userId)); // 服务方法名修改
    }

    @PostMapping("/deleteItem") // 方法名修改
    public Result deleteItem(@RequestBody Map<String, Object> item){ // 方法名修改
        Integer itemId = Integer.parseInt(item.get("itemId").toString()); // 字段名修改
        System.out.println("deleteItem" + itemId); // 输出信息修改
        itemService.delItem(itemId); // 服务方法名修改
        return new Result(200, "success", null);
    }
}
