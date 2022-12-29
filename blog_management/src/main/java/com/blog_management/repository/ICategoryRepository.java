package com.blog_management.repository;

import com.blog_management.model.Blog;
import com.blog_management.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select * from Blog where categori_id=:id", nativeQuery = true)
    List<Blog> findBlogInCategory(@Param("id") Integer id);

}

