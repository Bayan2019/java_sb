/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kz.bitlab.java_sb.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kz.bitlab.java_sb.entity.Task;
import kz.bitlab.java_sb.service.TaskService;

/**
 *
 * @author bayan
 */
@Service
public class TaskServiceImpl implements TaskService{

    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Long id_tasks = 6L;

    static {
        tasks.add(new Task(1L, "Create API on JAVA EE", "API creation and better understanding SQL", "2021-10-23", true));
        tasks.add(new Task(2L, "Clean house and buy products", "", "2021-10-25", true));
        tasks.add(new Task(3L, "Finish all homeworks", "", "2021-10-28", false));
        tasks.add(new Task(4L, "Make an appointment", "", "2021-12-12", false));
        tasks.add(new Task(5L, "Learn Italian", "", "2021-01-05", false));
    }

    @Override
    public ArrayList<Task> getAllTasks() {
        return tasks;
    }

    @Override
    public void addTask(Task task) {
        task.setId(id_tasks);
        id_tasks++;
        tasks.add(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return tasks.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public int getTaskIndex(Long id) {
        for (int i = 0; i < getAllTasks().size(); i++) {
            if (getAllTasks().get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void updateTaskById(Long id, Task task) {
        tasks.set(getTaskIndex(id), task);
    }

    @Override
    public void deleteTaskById(Long id) {
        tasks.remove(getTaskById(id));
    }
}
