package com.vietcodedi.onlineshopping.controller;

import com.vietcodedi.onlineshopping.model.Product;
import com.vietcodedi.onlineshopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String index(Model model){
        //Khởi tạo và Lấy data từ ProductService
        service.initialList();
        List<Product> products = service.getProducts();
        //Truyền dữ liệu sang cho Index
        model.addAttribute("products",products);
        return "admin/product/index";
    }

    @GetMapping("/add")
    public String add(){
        return "admin/product/add";
    }

    @PostMapping("/")
    public String save(Product product, RedirectAttributes redirectAttributes){
        try {
            service.saveProduct(product);//product này chưa được hiểu

            redirectAttributes.addFlashAttribute("message", "The Product has been saved successfully!");
        } catch (Exception e) {
            redirectAttributes.addAttribute("message", e.getMessage());
        }

        return "redirect:/products/";
    }

//    @PostMapping
//    public Product addProduct(@RequestBody Product product) {
//        return service.saveProduct(product);
//    }
//
//    @GetMapping
//    public List<Product> findAllProducts() {
//        return service.getProducts();
//    }
//
//    @GetMapping("{id}")
//    public Product findProductById(@PathVariable int id) {
//        return service.getProductById(id);
//    }
//
//    @PutMapping
//    public Product updateProduct(@RequestBody Product product) {
//        return service.updateProduct(product);
//    }
//
//    @DeleteMapping("{id}")
//    public String deleteProduct(@PathVariable int id) {
//        return service.deleteProduct(id);
//    }
}
