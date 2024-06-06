/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kz.bitlab.java_sb.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.bitlab.java_sb.model.ApplicationRequest;
import kz.bitlab.java_sb.repository.ApplicationRequestRepository;
import kz.bitlab.java_sb.service.ApplicationRequestService;

/**
 *
 * @author bayan
 */
@Service
public class ApplicationRequestServiceImpl implements ApplicationRequestService{

    @Autowired
    private ApplicationRequestRepository applicationRequestRepository;

    @Override
    public ArrayList<ApplicationRequest> getAllApplicationRequests() {
        return (ArrayList<ApplicationRequest>) applicationRequestRepository.findAll();
    }

    @Override
    public void addApplicationRequest(ApplicationRequest applicationRequest) {
        applicationRequestRepository.save(applicationRequest);
    }
}
