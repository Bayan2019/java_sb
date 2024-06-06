/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package kz.bitlab.java_sb.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kz.bitlab.java_sb.model.ApplicationRequest;

/**
 *
 * @author bayan
 */
@Service
public interface ApplicationRequestService {

    ArrayList<ApplicationRequest> getAllApplicationRequests();

    void addApplicationRequest(ApplicationRequest applicationRequest);

    void deleteApplicationRequest(Long id);

    void updateApplicationRequest(ApplicationRequest applicationRequest); 

    ApplicationRequest getApplicationRequestById(Long id);
}
