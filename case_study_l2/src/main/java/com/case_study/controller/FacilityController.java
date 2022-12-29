package com.case_study.controller;

import com.case_study.dto.FacilityDTO;
import com.case_study.model.Facility;
import com.case_study.model.FacilityType;
import com.case_study.model.RentType;
import com.case_study.service.IFacilityService;
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


@Controller
@RequestMapping("facility")
public class FacilityController {
    @Autowired
    IFacilityService facilityService;

    @ModelAttribute("facilityTypeList")
    public List<FacilityType> getListFacilityTypes() {
        return facilityService.findAllFacilityType();
    }

    @ModelAttribute("rentTypeList")
    public List<RentType> getListRentTypes() {
        return facilityService.findAllRentType();
    }

    @GetMapping
    public ModelAndView facilityList(@RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                                     @RequestParam(value = "facilityType", defaultValue = "") String facilityType,
                                     @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("facility/list");
        modelAndView.addObject("facilityList", facilityService.search(nameSearch, facilityType, pageable));
        modelAndView.addObject("nameSearch", nameSearch);
        modelAndView.addObject("facilityType", facilityType);
        return modelAndView;
    }

    @GetMapping("/delete")
    public String deleteFacility(@RequestParam int id, RedirectAttributes redirectAttributes) {
        facilityService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete customer successfully!");
        return "redirect:/facility";
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("facility/create");
        FacilityDTO facilityDTO = new FacilityDTO();
        modelAndView.addObject("facilityDTO", facilityDTO);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute @Validated FacilityDTO facilityDTO, BindingResult bindingResult) {
        new FacilityDTO().validate(facilityDTO, bindingResult);
        System.out.println(bindingResult);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("facility/create");
            modelAndView.addObject("facilityType", facilityDTO.getFacilityTypeId());
            modelAndView.addObject("message", "Add not Successful");
            modelAndView.addObject("facilityDTO", facilityDTO);
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("facility/create");
        modelAndView.addObject("facilityType", facilityDTO.getFacilityTypeId());
        modelAndView.addObject("facilityDTO", facilityDTO);
        modelAndView.addObject("message", "Add new Successful");
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDTO, facility);
        facilityService.save(facility);
        return modelAndView;

    }

    @GetMapping("/edit/{id}/{facilityType}")
    public ModelAndView showEdit(@PathVariable int id, @PathVariable int facilityType) {
        ModelAndView modelAndView = new ModelAndView("facility/edit");
        Facility facility = facilityService.findFacilityByID(id);
        FacilityDTO facilityDTO = new FacilityDTO();
        BeanUtils.copyProperties(facility, facilityDTO);
        modelAndView.addObject("facilityDTO", facilityDTO);
        modelAndView.addObject("facilityType", facilityType);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute @Validated FacilityDTO facilityDTO, BindingResult bindingResult) {
        new FacilityDTO().validate(facilityDTO, bindingResult);
        System.out.println(bindingResult);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("facility/edit");
            modelAndView.addObject("facilityType", facilityDTO.getFacilityTypeId());
            modelAndView.addObject("message", "Update not Successful");
            modelAndView.addObject("facilityDTO", facilityDTO);
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("facility/edit");
        modelAndView.addObject("facilityType", facilityDTO.getFacilityTypeId());
        modelAndView.addObject("facilityDTO", facilityDTO);
        modelAndView.addObject("message", "Update new Successful");
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDTO, facility);
        facilityService.save(facility);
        return modelAndView;

    }
}
