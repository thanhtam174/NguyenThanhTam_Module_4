package com.codegym.controller;

import com.codegym.models.Blog;
import com.codegym.sevices.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveCustomer(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/blogs")
    public ModelAndView getList(){
        return new ModelAndView("list","blogList",blogService.findAll());
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
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
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
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
    public ModelAndView view(@PathVariable Integer id){
        return new ModelAndView("view","blog",blogService.findById(id));
    }
}
