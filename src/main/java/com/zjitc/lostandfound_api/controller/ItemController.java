package com.zjitc.lostandfound_api.controller;

import com.zjitc.lostandfound_api.pojo.Item;
import com.zjitc.lostandfound_api.pojo.Notice;
import com.zjitc.lostandfound_api.pojo.Result;
import com.zjitc.lostandfound_api.service.ItemService;
import com.zjitc.lostandfound_api.service.UserService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Resource
    ItemService itemService;
    @Resource
    UserService userService;

    @GetMapping("/list")
    public Result getAll(){
        System.out.println("get all");
        return new Result(200, "success", itemService.findAll());
    }
    @GetMapping("/newestList")
    public Result getNewestList(){
        System.out.println("getNewestList");
        return new Result(200, "success", itemService.findNewest());
    }
    @GetMapping("/getItemById/{id}")
    public Result getItemById(@PathVariable Integer id){
        System.out.println("getItemById");
        return new Result(200, "success", itemService.getById(id));
    }

    @GetMapping("/getItemByCategory/{cate}")
    public Result getItemByCategory(@PathVariable String cate){
        System.out.println("getItemByCategory===" + cate);
        return new Result(200, "success", itemService.findByCategory(cate));
    }

    @GetMapping("/getCategory")
    public Result getCategory(){
        System.out.println("getItemById");
        return new Result(200, "success", itemService.findCategory());
    }

    @GetMapping("/commentsByItemId/{id}")
    public Result getCommentsByItemId(@PathVariable Integer id){
        System.out.println("getCommentsByItemId");
        return new Result(200, "success", itemService.getCommentsByItemId(id));
    }

    @PostMapping("/addItemComment")
    public Result addItemComment(@RequestBody Map<String, Object> comment, @RequestHeader(name="Authorization") String token){
        System.out.println("addItemComment");

        String content = comment.get("content").toString();
        Integer itemId = Integer.parseInt(comment.get("itemId").toString());
        itemService.updateItemCommentCounts(itemId);
        String name = userService.getUserName(token);
        itemService.addComment(name, content, itemId);
        return new Result(200, "success", null);
    }

    @PostMapping("/addItemCommentReply")
    public Result addItemCommentReply(@RequestBody Map<String, Object> comment, @RequestHeader(name="Authorization") String token){
        System.out.println(comment.get("content") + "===" + comment.get("commentId"));

        String content = comment.get("content").toString();
        Integer itemId = Integer.parseInt(comment.get("itemId").toString());
        Integer commentId = Integer.parseInt(comment.get("commentId").toString());
        itemService.updateItemCommentCounts(itemId);
        String name = userService.getUserName(token);
        itemService.addCommentReply(name, content, commentId, itemId);
        return new Result(200, "success", null);
    }

    @PostMapping("/addItem")
    public Result addItem(@RequestBody Map<String, Object> item, @RequestHeader(name="Authorization") String token){
//        System.out.println(item.get("content") + "===" + item.get("picUrl") + "===" + item.get("title") + "===" + item.get("category"));
        String name = userService.getUserName(token);
        itemService.addItem(name, item);
        return new Result(200, "success", null);
    }

    @PostMapping("/updateItem")
    public Result updateItem(@RequestBody Map<String, Object> item){
        System.out.println("updateItem");
        itemService.updateItem(item);
        return new Result(200, "success", null);
    }
    @PostMapping("/updateItemViewCounts/{itemId}")
    public Result updateItemViewCounts(@PathVariable Integer itemId){
        System.out.println("updateItem");
        itemService.updateItemViewCounts(itemId);
        return new Result(200, "success", null);
    }

    @GetMapping("/hotItem")
    public Result hotItem(){
        System.out.println("hotItem");
        return new Result(200, "success", itemService.findItemByViews());
    }

    @GetMapping("/getItemByUser")
    public Result getItemByUser(@RequestHeader(name="Authorization") String token){
        System.out.println("getItemByUser");
        Integer userId = userService.getUserId(token);
        return new Result(200, "success", itemService.findByUser(userId));
    }

    @PostMapping("/deleteItem")
    public Result deleteItem(@RequestBody List<Integer> ids){
        System.out.println("deleteItem"+ids);
        itemService.delItem(ids);
        return new Result(200, "success", null);
    }
    @PostMapping("/sendContact")
    public Result sendContact(@RequestHeader(name="Authorization") String token,@RequestBody Map<String, Object> params){
        System.out.println("sendContact"+params.get("tradeTime"));
        userService.sendContact(params, token);

        return new Result(200, "success", null);
    }

    @GetMapping("/getItemByParams")
    public Result getItemByParams(@RequestParam(required = false) String category,
                                  @RequestParam(required = false) String title){
        System.out.println("getItemByParams"+category+"===="+title);
        List<Item> items = itemService.findByParams(category, title);
        System.out.println(items);
        return new Result(200, "success", items);
    }
    @PostMapping("/addCategory")
    public Result addCategory(@RequestBody Map<String, Object> params){
        return new Result(200, "success", itemService.addCategory(params));
    }
    @PostMapping("/updateCategory")
    public Result updateCategory(@RequestBody Map<String, Object> params){
        return new Result(200, "success", itemService.updateCategory(params));
    }
    @PostMapping("/deleteCategory")
    public Result deleteCategory(@RequestBody List<Integer> ids){
        return new Result(200, "success", itemService.deleteCategory(ids));
    }
}
