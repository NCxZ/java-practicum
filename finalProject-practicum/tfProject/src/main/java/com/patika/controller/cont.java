package com.patika.controller;

import com.patika.entity.comment;
import com.patika.entity.product;
import com.patika.entity.user;
import com.patika.service.CommentService;
import com.patika.service.ProdService;
import com.patika.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;

@RestController
public class cont {

    @Autowired
    CommentService comiser;

    @Autowired
    UserService umiser;

    @Autowired
    ProdService productService;

    @PostMapping("/addProduct")
    public product addProduct(@RequestBody product product){
        return productService.addProduct(product);
    }

    @PostMapping("/addUser")
    public user addUser(@RequestBody user user){
        return umiser.addUser(user);
    }

    @PostMapping("/addComment")
    public comment addUser(@RequestBody comment comment){
        return comiser.addComment(comment);
    }

    @GetMapping("/getCommentsByProdId/{id}")
    public Iterable<comment> getCommentsByProdId(@PathVariable("id") int prodid){
        return comiser.getCommentsByProductId(prodid);
    }
    @GetMapping("/getProductCommentsByDate/{id}")
    public Iterable<comment> getProductCommentsByDate(@PathVariable("id") int prodid,@RequestParam(name = "startDate") String startDate
            , @RequestParam(name = "endDate") String endDate) throws ParseException {
        return comiser.getProductCommentsByDate(prodid,startDate,endDate);
    }

    @GetMapping("/getCommentsByUserId/{id}")
    public Iterable<comment> getCommentsByUserId(@PathVariable("id") int userid){
        return comiser.getCommentsByUserId(userid);
    }

    @GetMapping("/getCommentsByUserIdAndDate/{id}")
    public Iterable<comment> getCommentsByUserIdAndDate(@PathVariable("id") int userid,@RequestParam(name = "startDate") String startDate
            , @RequestParam(name = "endDate") String endDate) throws ParseException {
        return comiser.getUserCommentsByDate(userid,startDate,endDate);
    }

    @GetMapping("/getExpiredProducts")
    public Iterable<product> getExpiredProducts() throws ParseException {
        return productService.getExpiredProducts();
    }
    @GetMapping("/getFreshProducts")
    public Iterable<product> getFreshProducts() throws ParseException {
        return productService.getFreshProducts();
    }

}
