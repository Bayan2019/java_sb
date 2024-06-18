/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kz.bitlab.java_sb.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.bitlab.java_sb.model.Course;
import kz.bitlab.java_sb.repository.CourseRepository;
import kz.bitlab.java_sb.service.CourseService;

/**
 *
 * @author bayan
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public ArrayList<Course> getAllCourses() {
        return (ArrayList<Course>) courseRepository.findAll();
    }
}
