package com.example.ontap_thi.controller;

import com.example.ontap_thi.model.QuestionType;
import com.example.ontap_thi.service.QuestionContentService;
import com.example.ontap_thi.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("questioncontents")
public class QuestionContentController {
    @Autowired
    private QuestionTypeService questionTypeService;

    @Autowired
    private QuestionContentService questionContentService;

    @ModelAttribute("questiontypes")
    public List<QuestionType> listQuestionType() {
        return questionTypeService.findAllQuestionType();
    }

    @GetMapping
    public ModelAndView questionContentlist(@RequestParam(value = "date", defaultValue = "") String date,
                                            @RequestParam(value = "title", defaultValue = "") String title,
                                            @RequestParam(value = "questionType", defaultValue = "") String questionType,
                                            Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("questioncontent/list");
        modelAndView.addObject("questioncontents", questionContentService.search(date, title, questionType, pageable));
        modelAndView.addObject("date", date);
        modelAndView.addObject("title", title);
        modelAndView.addObject("questionType", questionType);
        return modelAndView;
    }

    @GetMapping("/delete")

    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        questionContentService.delete(id);
        redirectAttributes.addFlashAttribute("messege", "Delete schedule successfully!");
        return "redirect:/questioncontents";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("viewQuestionContent", questionContentService.findById(id));
        return "/questioncontent/view";
    }
}
