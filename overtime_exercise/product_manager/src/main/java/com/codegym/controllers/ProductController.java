package com.codegym.controllers;

import com.codegym.models.Category;
import com.codegym.models.Product;
import com.codegym.services.CategoryService;
import com.codegym.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/product")
@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;


    @ModelAttribute("categories")
    public Iterable<Category> categories(Pageable pageable) {
        return categoryService.findAll(pageable);
    }

    @GetMapping
    public ModelAndView getProductList(@PageableDefault(value = 10)Pageable pageable){
       Page<Product> products = productService.findAll(pageable);;
       ModelAndView modelAndView = new ModelAndView("product/list");
       modelAndView.addObject("products",products);
       return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        return new ModelAndView("/product/create","product",new Product());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product){
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Product product = productService.findById(id);
        return new ModelAndView("/product/edit","product",product);
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("product") Product product){
        productService.save(product);

        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Product product = productService.findById(id);
        return new ModelAndView("/product/delete","product",product);
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("product") Product product){
        productService.deleteById(product.getId());
        return "redirect:/product";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView view(@PathVariable Long id){
        Product product = productService.findById(id);
        return new ModelAndView("/product/detail","product",product);
    }
}
