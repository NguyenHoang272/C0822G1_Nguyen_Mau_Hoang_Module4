package blogmanagement.blogmanagement.service;

import blogmanagement.blogmanagement.model.Blog;
import blogmanagement.blogmanagement.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(int id);

    void update(Category category);

    void remove(int id);

}
