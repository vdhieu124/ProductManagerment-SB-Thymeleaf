package com.multicampus.demospringthymeleaf.controllers;

import com.multicampus.demospringthymeleaf.models.Product;
import com.multicampus.demospringthymeleaf.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String index(Model model){
        //Khởi tạo và Lấy data từ ProductService
        List<Product> products = service.getProducts();
        //Truyền dữ liệu sang cho Index
        model.addAttribute("products",products);
        return "admin/product/index";
    }

    @GetMapping("/add")
    public String add(){
        return "admin/product/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute Product product){
        service.saveProduct(product);//product này chưa được hiểu
        return "redirect:/";
    }
}
