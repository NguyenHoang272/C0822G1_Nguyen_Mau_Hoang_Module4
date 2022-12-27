package com.book_order.controller;


import com.book_order.model.Book;
import com.book_order.model.BookOrder;
import com.book_order.service.book_service.IBookService;
import com.book_order.service.order_service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping("")
public class BookOrderController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IOrderService oderService;

@GetMapping("/")
    public String showList(Model model){
    model.addAttribute("books",bookService.finAll());
    return"book/list";
}

@GetMapping("/order/{id}")
    public String showOder(@PathVariable int id, Model model){
    Book book = bookService.finById(id);
    model.addAttribute("book",book);
    return "/book/oder_form";
}
    @PostMapping("/order")
    public String order(@RequestParam Integer id, Model model) {

        int otp = (int) (Math.random() * (99999 - 10000) + 10000);
        Book book = bookService.finById(id);
        String orderDate = String.valueOf(new Date(System.currentTimeMillis()));

        BookOrder bookOrder = new BookOrder(otp, orderDate, book);
        oderService.save(bookOrder);

        book.setStock(book.getStock() - 1);
        bookService.save(book);

        model.addAttribute("message",
                "Successfully order! Your order OTP is: " + otp);
        return "book/notification";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam int otp, RedirectAttributes redirect) {
        BookOrder bookOrder = oderService.finByOtp(otp);

        String returnDate = String.valueOf(new Date(System.currentTimeMillis()));
        bookOrder.setReturnDate(returnDate);
        oderService.save(bookOrder);

        Book book = bookOrder.getBook();
        book.setStock(book.getStock() + 1);
        bookService.save(book);

        redirect.addFlashAttribute("message", "Return book successful! Thank you!");
        return "redirect:";
    }

    @ExceptionHandler
    public String handleException(Exception e, Model model) {
        e.printStackTrace();
        model.addAttribute("message", "OTP is invalid!");
        return "error";
    }
}
