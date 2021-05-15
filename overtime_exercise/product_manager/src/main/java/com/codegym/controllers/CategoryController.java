package com.codegym.controllers;

import com.codegym.models.Category;
import com.codegym.models.Product;
import com.codegym.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ModelAndView getList(@PageableDefault(value = 10) Pageable pageable){
        Page<Category> categories = categoryService.findAll(pageable);;
        ModelAndView modelAndView = new ModelAndView("category/list");
        modelAndView.addObject("categories",categories);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        return new ModelAndView("/category/create","category",new Category());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("category") Category category){
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Category category = categoryService.findById(id);
        return new ModelAndView("/category/edit","category",category);
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("category") Category category){
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Category category = categoryService.findById(id);
        return new ModelAndView("/category/delete","category",category);
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("category") Category category){
        categoryService.deleteById(category.getId());
        return "redirect:/category";
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable Long id){
        List<Product> products = categoryService.findById(id).getProducts();
        ModelAndView modelAndView = new ModelAndView("/category/view");
        modelAndView.addObject("products",products);
        return modelAndView;
    }
}
