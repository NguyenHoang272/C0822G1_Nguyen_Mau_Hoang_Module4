package com.blog_management.rest_controller;


import com.blog_management.model.Category;
import com.blog_management.service.blog_service.IBlogService;
import com.blog_management.service.category_service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/categories")
@CrossOrigin("*")
public class RestCategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<List<Category>> list() {
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<List<Blog>> findById(@PathVariable int id){
//        List<Blog> blogList = blogService.findByCategory(id);
//        if (blogList.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogList, HttpStatus.OK);
//    }


}

