/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package kz.bitlab.java_sb.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kz.bitlab.java_sb.model.Course;

/**
 *
 * @author bayan
 */
@Service
public interface CourseService {

    ArrayList<Course> getAllCourses();
}
