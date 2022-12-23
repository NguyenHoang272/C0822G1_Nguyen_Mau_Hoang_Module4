package exercise.user_login.controller;

import exercise.user_login.dto.UserDto;
import exercise.user_login.model.User;
import exercise.user_login.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("users", userService.finALL());
        return "user/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user/create";
    }

    @PostMapping("/create")
    public String createUser(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.save(user);
            model.addAttribute("message", "Added user successfully!");
        } else {
            model.addAttribute("message", "Add new user failure!");
        }

        return "user/create";
    }


}
