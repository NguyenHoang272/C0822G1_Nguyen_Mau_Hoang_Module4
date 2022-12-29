package com.blog_management.service.category_service;

import com.blog_management.model.Blog;
import com.blog_management.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(Integer id);

    void update(Category category);

    void remove(Category category);

    List<Blog> findBlogInCategory(Integer id);
}
