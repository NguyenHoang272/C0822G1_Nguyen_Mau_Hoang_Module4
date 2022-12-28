package com.cart.controller;

import com.cart.dto.CartDto;
import com.cart.dto.ProductDto;
import com.cart.model.Product;
import com.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public CartDto initCart(){
        return new CartDto();
    }

    @Autowired
    private IProductService  iProductService;

    @GetMapping
    public ModelAndView showListPage(Model model,@CookieValue(value = "idProduct",defaultValue = "-1") Integer idProduct){
        if (idProduct != -1){
            model.addAttribute("historyProduct",iProductService.findById(idProduct).get());
        }
        return new ModelAndView("views/product/list","productList",iProductService.findAll());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable Integer id, HttpServletResponse response){
        Cookie cookie = new Cookie("idProduct",String.valueOf(id));
        cookie.setMaxAge(30);
        cookie.setPath("/");
        response.addCookie(cookie);

        return new ModelAndView("views/product/detail","product",iProductService.findById(id).get());
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id,@SessionAttribute("cart") CartDto cart){
        Optional<Product> productDetail = iProductService.findById(id);
        if (productDetail.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(),productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/decrease/{id}")
    public String decreaseToCart(@PathVariable Integer id,@SessionAttribute("cart") CartDto cart){
        Optional<Product> productDetail = iProductService.findById(id);
        if (productDetail.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(),productDto);
            cart.decreaseProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/delete/{id}")
    public String deleteToCart(@PathVariable Integer id,@SessionAttribute("cart") CartDto cart){
        Optional<Product> productDetail = iProductService.findById(id);
        if (productDetail.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(),productDto);
            cart.remove(productDto);
        }
        return "redirect:/cart";
    }
}
