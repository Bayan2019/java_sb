package kz.bitlab.java_sb.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.bitlab.java_sb.model2.Task;
import kz.bitlab.java_sb.repository2.TaskRepository;
import kz.bitlab.java_sb.service.TaskService2;

@Service
public class TaskServiceImpl2 implements TaskService2{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public ArrayList<Task> getAllTasks() {
        return (ArrayList<Task>) taskRepository.findAll();
    }

    @Override
    public void addTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public void updateTaskById(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}
