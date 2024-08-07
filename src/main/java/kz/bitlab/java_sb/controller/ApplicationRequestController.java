/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kz.bitlab.java_sb.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kz.bitlab.java_sb.model.ApplicationRequest;
import kz.bitlab.java_sb.model.Operator;
import kz.bitlab.java_sb.service.impl.ApplicationRequestServiceImpl;
import kz.bitlab.java_sb.service.impl.CourseServiceImpl;
import kz.bitlab.java_sb.service.impl.OperatorServiceImpl;



/**
 *
 * @author bayan
 */
@Controller
public class ApplicationRequestController {

    @Autowired
    private ApplicationRequestServiceImpl applicationRequestService;
    @Autowired
    private CourseServiceImpl courseService;
    @Autowired
    private OperatorServiceImpl operatorService;

    @GetMapping(value="/crm")
    public String mainPage(Model model) {
        model.addAttribute("applicationRequests", applicationRequestService.getAllApplicationRequests());
        return "sprint2/main";
    }

    @GetMapping(value="/crm/add-request")
    public String addRequest(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());        
        return "sprint2/add-request";
    }
    
    @PostMapping(value="/crm/add-request")
    public String addRequestP(@RequestParam String userName, @RequestParam String courseName, @RequestParam String commentary, @RequestParam String phone) {
        ApplicationRequest applicationRequest = new ApplicationRequest();
        applicationRequest.setUserName(userName);
        // applicationRequest.setCourseName(courseName);
        applicationRequest.setCommentary(commentary);
        applicationRequest.setPhone(phone);
        applicationRequest.setHandled(false);

        applicationRequestService.addApplicationRequest(applicationRequest);
        return "redirect:/crm";
    }

    @GetMapping(value = "/crm/detail-request/{id}")
    public String detailRequest(Model model, @PathVariable Long id) {
        ApplicationRequest ar = applicationRequestService.getApplicationRequestById(id);
        ArrayList<Operator> operators = operatorService.getAllOperators();
        model.addAttribute("ar", ar);
        model.addAttribute("courses", courseService.getAllCourses());
        model.addAttribute("operators", operators);
        return "sprint2/detail-request";
    }
    
    @PostMapping(value = "/crm/detail-request")
    public String detailRequestUpdate(ApplicationRequest applicationRequest) {
        applicationRequestService.updateApplicationRequest(applicationRequest);
        return "redirect:/crm/detail-request/"+applicationRequest.getId().toString();
    }

    @PostMapping(value = "/crm/detail-request/process")
    public String detailRequestProcessed(@RequestParam Long application_request_id, @RequestParam Integer[] operators) {
        ApplicationRequest ar = applicationRequestService.getApplicationRequestById(application_request_id);
        for (int operator_id:operators) {
            if (operator_id!=0) {
                ar.getOperators().add(operatorService.getOperatorById(operator_id));
            }
        }
        applicationRequestService.updateApplicationRequest(ar);
        applicationRequestService.processApplicationRequest(ar);
        return "redirect:/crm/detail-request/"+application_request_id.toString();
    }

    @PostMapping(value = "/crm/detail-request/delete")
    public String detailRequestDelete(@RequestParam Long id) {
        applicationRequestService.deleteApplicationRequest(id);
        return "redirect:/crm";
    }

    @PostMapping(value="/crm/detail-request/delete-operator")
    public String deleteOperator(@RequestParam Long application_request_id, @RequestParam int operator_id) {
        ApplicationRequest ar = applicationRequestService.getApplicationRequestById(application_request_id);
        Operator operator = operatorService.getOperatorById(operator_id);
        ar.getOperators().remove(operator);
        applicationRequestService.updateApplicationRequest(ar);

        return "redirect:/crm/detail-request/"+application_request_id;
    }

}
