/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package kz.bitlab.java_sb.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kz.bitlab.java_sb.entity.Task;

/**
 *
 * @author bayan
 */
@Service
public interface TaskService {

    ArrayList<Task> getAllTasks();

    void addTask(Task task);

    Task getTaskById(Long id);

    int getTaskIndex(Long id);

    void updateTaskById(Long id, Task task);

    void deleteTaskById(Long id);
}
