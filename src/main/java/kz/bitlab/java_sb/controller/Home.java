package kz.bitlab.java_sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kz.bitlab.java_sb.entity.Film;
import kz.bitlab.java_sb.entity.Item;
import kz.bitlab.java_sb.entity.Student;
import kz.bitlab.java_sb.entity.Task;
import kz.bitlab.java_sb.service.impl.FilmServiceImpl;
import kz.bitlab.java_sb.service.impl.ItemServiceImpl;
import kz.bitlab.java_sb.service.impl.StudentServiceImpl;
import kz.bitlab.java_sb.service.impl.TaskServiceImpl;


@Controller
public class Home {

    @Autowired
    private FilmServiceImpl filmService;
    @Autowired
    private ItemServiceImpl itemService;
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private TaskServiceImpl taskService;

    @GetMapping(value="/")
    public String mainPage(Model model) {
        model.addAttribute("films", filmService.getAllFilms());
        return "main";
    }

    @PostMapping(value = "/add-film")
    public String addFilm(Film film) {
        filmService.addFilm(film);
        return "redirect:/";
    }

    @GetMapping(value = "/bitlab-academy")
    public String bitlabAcademyMain(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "sprint1/main";
    }
    
     @PostMapping(value = "/bitlab-academy")
    public String bitlabAcademyAddItemP(Student student) {
        studentService.addStudent(student);
        return "redirect:/bitlab-academy";
    }

    @GetMapping(value = "/bitlab-shop")
    public String bitlabShop(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "ch1/main";
    }

    @GetMapping(value = "/bitlab-shop/add-item")
    public String bitlabShopAddItem(Model model) {
        return "ch1/addItem";
    }

    @PostMapping(value = "/bitlab-shop/add-item")
    public String bitlabShopAddItemP(Item item) {
        itemService.addItem(item);
        return "redirect:/bitlab-shop";
    }

    @GetMapping(value = "/bitlab-shop/detail/{id}")
    public String bitlabShopDetail(Model model, @PathVariable Long id) {
        model.addAttribute("item", itemService.getItemById(id));
        return "ch1/detail";
    }

    @PostMapping(value = "/bitlab-shop/detail")
    public String bitlabShopDetailP(Item item) {
        itemService.updateItemById(item.getId(), item);
        return "redirect:/bitlab-shop";
    }

    @PostMapping(value = "/bitlab-shop/delete")
    public String bitlabShopDelete(@RequestParam Long id) {
        itemService.deleteItemById(id);
        return "redirect:/bitlab-shop";
    }

    @GetMapping(value = "/task-manager")
    public String taskManager(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "ch4/main";
    }

    @PostMapping(value = "/task-manager/add-task")
    public String taskManagerAddTask(@RequestParam String name, @RequestParam String description, 
        @RequestParam String deadlineDate) {

        Task task = new Task();
        task.setName(name);
        task.setDescription(description);
        task.setDeadlineDate(deadlineDate);
        task.setStatus(false);

        taskService.addTask(task);
        return "redirect:/task-manager";
    }

    @GetMapping(value = "/task-manager/detail/{id}")
    public String taskManagerDetails(Model model, @PathVariable Long id) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "ch4/detail";
    }

    @PostMapping(value = "/task-manager/detail")
    public String taskManagerDetailsUpdate(@RequestParam Long id, @RequestParam String name, 
        @RequestParam String description, @RequestParam String deadlineDate, @RequestParam String status) {

        Boolean completed = (status.equals("yes"));
        Task task = new Task(id, name, description, deadlineDate, completed);
        taskService.updateTaskById(task.getId(), task);
        return "redirect:/task-manager";
    }

    @PostMapping(value = "/task-manager/delete/{id}")
    public String taskManagerDelete(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return "redirect:/task-manager";
    }
    
}
