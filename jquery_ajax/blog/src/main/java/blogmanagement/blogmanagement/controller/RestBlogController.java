package blogmanagement.blogmanagement.controller;

import blogmanagement.blogmanagement.dto.BlogDto;
import blogmanagement.blogmanagement.model.Blog;
import blogmanagement.blogmanagement.model.Category;
import blogmanagement.blogmanagement.service.IBlogService;
import blogmanagement.blogmanagement.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/blog/v1")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;


    @GetMapping("")
    public ResponseEntity<List<Blog>> showList(@PageableDefault(value = 1, sort = "date_created", direction = Sort.Direction.DESC)
                                               Pageable pageable) {
        Page<Blog> blogList = blogService.findPageable(pageable);

        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogList.getContent(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> showList(@RequestParam(value = "search")
                                               String search) {

        List<Blog> blogList = blogService.findByTitleContaining(search);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Blog>> blogOfCategory(@RequestBody int idCategory) {
        Category category = categoryService.findById(idCategory);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Blog> blogList = blogService.findByCategory(category);
        if (blogList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/detail")
    public ResponseEntity<Blog> blogDetail(@RequestBody int idBlog) {
        Blog blog = blogService.findById(idBlog);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable int id, @RequestBody Blog blog) {
        Blog currentBlog = blogService.findById(id);
        if (currentBlog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

}
