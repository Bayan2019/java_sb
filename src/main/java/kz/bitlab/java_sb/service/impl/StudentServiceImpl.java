/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kz.bitlab.java_sb.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kz.bitlab.java_sb.entity.Student;
import kz.bitlab.java_sb.service.StudentService;

/**
 *
 * @author bayan
 */
@Service
public class StudentServiceImpl implements StudentService{

    private static ArrayList<Student> students = new ArrayList<>();
    private static Long id_students = 6L;

    static {
        students.add(new Student(1L, "Ilyas", "Zhuanyshev", 88));
        students.add(new Student(2L, "Madina", "Adltetova", 77));
        students.add(new Student(3L, "Serik", "Erikov", 48));
        students.add(new Student(4L, "Patrick", "Zuckerberg", 99));
        students.add(new Student(5L, "Sabina", "Assetova", 33));
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        return students;
    }

    @Override
    public void addStudent(Student student) {
        student.setId(id_students);
        student.setMark();
        id_students++;
        students.add(student);
    }
}
