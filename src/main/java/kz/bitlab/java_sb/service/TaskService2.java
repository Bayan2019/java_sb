package kz.bitlab.java_sb.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kz.bitlab.java_sb.model2.Task;

@Service
public interface TaskService2 {

    ArrayList<Task> getAllTasks();

    void addTask(Task task);

    Task getTaskById(Long id);

    void updateTaskById(Task task);

    void deleteTaskById(Long id);

}
