package com.codegym.controller;

import com.codegym.models.Blog;
import com.codegym.models.Category;
import com.codegym.sevices.BlogService;
import com.codegym.sevices.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categorys() {
        return categoryService.findAll();
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveCustomer(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/blogs")
    public ModelAndView getList(@PageableDefault(value = 5)Pageable pageable){
        return new ModelAndView("/blog/list","blogList",blogService.findAll(pageable));
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateCustomer(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/delete");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-blog")
    public String deleteCustomer(@ModelAttribute("blog") Blog blog) {
        blogService.deleteById(blog.getId());
        return "redirect:blogs";
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView view(@PathVariable Long id){
        return new ModelAndView("/blog/view","blog",blogService.findById(id));
    }
}
