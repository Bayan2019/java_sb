/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kz.bitlab.java_sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kz.bitlab.java_sb.repository.ApplicationRequestRepository;


/**
 *
 * @author bayan
 */
@Controller
public class ApplicationRequestController {

    @Autowired
    private ApplicationRequestRepository applicationRequestRepository;

    @GetMapping(value="/crm")
    public String mainPage(Model model) {
        model.addAttribute("applicationRequests", applicationRequestRepository.findAll());
        return "sprint2/main";
    }
    

}
