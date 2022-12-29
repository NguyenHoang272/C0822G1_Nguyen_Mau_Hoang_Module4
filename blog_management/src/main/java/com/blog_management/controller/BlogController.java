//package com.blog_management.controller;
//
//import com.blog_management.model.Blog;
//import com.blog_management.model.Category;
//import com.blog_management.service.blog_service.IBlogService;
//import com.blog_management.service.category_rervice.ICategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.util.Date;
//import java.util.List;
//
//@Controller
//@RequestMapping({"/blog", "/"})
//public class BlogController {
//
//    @Autowired
//    private IBlogService blogService;
//
//    @ModelAttribute("categories")
//    public List<Category> getAllCategories() {
//        return categoryService.findAll();
//    }
//
//    @Autowired
//    private ICategoryService categoryService;
//
//    @GetMapping
//    public String search(@RequestParam(value = "searchTitle", defaultValue = "") String searchTitle,
//                         @RequestParam(value = "searchCategory", defaultValue = "") String searchCategory,
//                         Model model,
//                         @PageableDefault(value = 3) Pageable pageable) {
//        Page<Blog> blogs = blogService.findByTitleAndCategory(searchTitle, searchCategory, pageable);
//        model.addAttribute("blogs", blogs);
//        model.addAttribute("searchTitle", searchTitle);
//        model.addAttribute("searchCategory", searchCategory);
//        return "blog/list";
//    }
//
//
//    @GetMapping("/{id}/delete")
//    public String delete(@PathVariable int id, Model model) {
//        model.addAttribute("blog", blogService.findById(id));
//        return "blog/delete";
//    }
//
//    @PostMapping("/delete")
//    public String delete(@RequestParam Integer id, RedirectAttributes redirect) {
//        blogService.remove(blogService.findById(id));
//        redirect.addFlashAttribute("message", "Successfully removed");
//        return "redirect:/blog";
//    }
//
//    @GetMapping("/create")
//    public String create(Model model) {
//        model.addAttribute("blog", new Blog());
//        return "blog/create";
//    }
//
//    @PostMapping("/create")
//    public String create(@ModelAttribute Blog blog, RedirectAttributes redirect) {
//        blog.setTime(new Date().toString());
//        blogService.save(blog);
//        redirect.addFlashAttribute("message", "Successfully added");
//        return "redirect:/blog/create";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(@PathVariable int id, Model model) {
//        model.addAttribute("blog", blogService.findById(id));
//        return "blog/edit";
//    }
//
//    @PostMapping("/edit")
//    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirect) {
//        blog.setTime(new Date().toString());
//        blogService.update(blog);
//        redirect.addFlashAttribute("message", "Successfully updated");
//        return "redirect:/blog";
//    }
//
//    @GetMapping("/{id}/view")
//    public String details(@PathVariable int id, Model model) {
//        model.addAttribute("blog", blogService.findById(id));
//        return "blog/view";
//    }
//
//}
