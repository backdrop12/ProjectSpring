package ProjectSpringWeb.controller;

import ProjectSpringWeb.model.*;
import ProjectSpringWeb.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mvc")
@RequiredArgsConstructor
public class UserMvcController {

    private final UserService userService;

    @GetMapping
    public String getUsers(Model model) {
        List<UserReturnDto> userList = UserService.getUsers();
        model.addAttribute("userList", userList);
        return "users";
    }


    @PostMapping("/createUsers")
    public String createUsers(@ModelAttribute UserCreateDto userCreateDto, Model model) {
        model.addAttribute("userCreateDto",userCreateDto);
        UserService.createUsers(userCreateDto);
        return "redirect:/mvc";
    }



}
