package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;


    @GetMapping("/list")
    public String showList(@RequestParam(defaultValue = "") String search, @PageableDefault(page = 0, size = 5) Pageable pageable, ModelMap model) {
        Page<Blog> blogList = blogService.findAll(pageable);
        model.addAttribute("blogList", blogList);

        return "/blog/list";
    }


    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("blog", new Blog());

        return "/blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        List<Blog> blogs = blogService.findAll();
        for (Blog items : blogs) {
            if (blog.getName().equals(items.getName())) {
                redirectAttributes.addFlashAttribute("mess", "Fail");
                return "redirect:/blog/list";
            }
        }
        blogService.save(blog);
        return "redirect:/blog/list";


    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("editBlog", blogService.findById(id));
        return "/blog/edit";
    }

    @PostMapping("/edit")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        List<Blog> blogs = blogService.findAll();
        for (Blog items : blogs) {
            if (blog.getName().equals(items.getName())) {
                redirectAttributes.addFlashAttribute("mess", "Fail");
                return "redirect:/blog/list";
            } else {
                blogService.update(blog);
                redirectAttributes.addFlashAttribute("mess", "update new success");
            }
        }

        return "redirect:/blog/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirect) {
        blogService.remove(id);
        redirect.addFlashAttribute("mess", "Delete new success");
        return "redirect:/blog/list";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("viewBlog", blogService.findById(id));
        return "/blog/view";
    }


}
