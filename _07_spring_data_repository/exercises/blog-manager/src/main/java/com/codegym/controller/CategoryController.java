package com.codegym.controller;

import com.codegym.models.Category;
import com.codegym.sevices.BlogService;
import com.codegym.sevices.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;



    @GetMapping("/create-category")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("blog", new Category());
        return modelAndView;
    }

    @PostMapping("/create-category")
    public ModelAndView saveCustomer(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/categories")
    public ModelAndView getList(Pageable pageable){
        return new ModelAndView("list","categoryList",categoryService.findAll(pageable));
    }

    @GetMapping("/edit-category/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("category/edit");
            modelAndView.addObject("category", category);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-category")
    public ModelAndView updateCustomer(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-category/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("category/delete");
            modelAndView.addObject("category", category);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-category")
    public String deleteCustomer(@ModelAttribute("category") Category category) {
        categoryService.deleteById(category.getId());
        return "redirect:categories";
    }

    @GetMapping("/view-category/{id}")
    public ModelAndView view(@PathVariable Long id){
        return new ModelAndView("view","category",categoryService.findById(id));
    }

}