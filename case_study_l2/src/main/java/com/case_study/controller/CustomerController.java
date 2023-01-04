package com.case_study.controller;

import com.case_study.dto.CustomerDTO;
import com.case_study.model.Customer;
import com.case_study.model.CustomerType;
import com.case_study.service.ICustomerService;
import com.case_study.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @ModelAttribute("customerTypes")
    public List<CustomerType> getListCustomerTypes() {
        return customerTypeService.findAllCustomerType();
    }

    @GetMapping
    public ModelAndView list(@RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                             @RequestParam(value = "email", defaultValue = "") String email,
                             @RequestParam(value = "customerType", defaultValue = "") String customerType,
                             @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customerService.search(nameSearch, email, customerType, pageable));
        modelAndView.addObject("email", email);
        modelAndView.addObject("customerType", customerType);
        modelAndView.addObject("nameSearch", nameSearch);
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customerDTO", new CustomerDTO());
        return modelAndView;
    }

    @PostMapping("/create")
    private ModelAndView create(@Validated @ModelAttribute CustomerDTO customerDTO, BindingResult bindingResult) {
        new CustomerDTO().validate(customerDTO, bindingResult);
        ModelAndView modelAndView = new ModelAndView("customer/create");
        List<Customer> customers = customerService.findAll();
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getErrorCount());
            modelAndView.addObject("customerDTO", customerDTO);
            modelAndView.addObject("message", "Add new not success!");
            return modelAndView;
        }
        for (Customer items : customers) {
            if (customerDTO.getEmail().equals(items.getEmail())) {
                modelAndView.addObject("message", "Dup!");
                break;
            } else {
                Customer customer = new Customer();
                BeanUtils.copyProperties(customerDTO, customer);
                customerService.save(customer);
                modelAndView.addObject("customerDTO", customerDTO);
                modelAndView.addObject("message", "Add new Successful!");
                return modelAndView;
            }
        }
        return modelAndView;

    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam int id, RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete customer successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        Optional<Customer> customer = customerService.findCustomerById(id);
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer.get(), customerDTO);
        modelAndView.addObject("customerDTO", customerDTO);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute @Validated CustomerDTO customerDTO, BindingResult bindingResult) {
        new CustomerDTO().validate(customerDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("customer/edit");
            modelAndView.addObject("customerDTO", customerDTO);
            return modelAndView;
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customerDTO", customerDTO);
        modelAndView.addObject("message", "Customer edited successfully");
        return modelAndView;
    }

}
