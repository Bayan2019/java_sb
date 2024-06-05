package kz.bitlab.java_sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kz.bitlab.java_sb.db.DBManager;
import kz.bitlab.java_sb.db.Item;
import kz.bitlab.java_sb.db.Student;
import kz.bitlab.java_sb.db.Task;
import kz.bitlab.java_sb.entity.Film;
import kz.bitlab.java_sb.service.impl.FilmServiceImpl;


@Controller
public class Home {

    @Autowired
    private FilmServiceImpl filmService;

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
        model.addAttribute("students", DBManager.getAllStudents());
        return "sprint1/main";
    }
    
     @PostMapping(value = "/bitlab-academy")
    public String bitlabAcademyAddItemP(Student student) {
        DBManager.addStudent(student);
        return "redirect:/bitlab-academy";
    }

    @GetMapping(value = "/bitlab-shop")
    public String bitlabShop(Model model) {
        model.addAttribute("items", DBManager.getAllItems());
        return "ch1/main";
    }

    @GetMapping(value = "/bitlab-shop/add-item")
    public String bitlabShopAddItem(Model model) {
        return "ch1/addItem";
    }

    @PostMapping(value = "/bitlab-shop/add-item")
    public String bitlabShopAddItemP(Item item) {
        DBManager.addItem(item);
        return "redirect:/bitlab-shop";
    }

    @GetMapping(value = "/bitlab-shop/details/{id}")
    public String bitlabShopDetail(Model model, @PathVariable Long id) {
        model.addAttribute("item", DBManager.getItemById(id));
        return "ch1/detail";
    }

    @PostMapping(value = "/bitlab-shop/details")
    public String bitlabShopDetailP(Item item) {
        DBManager.updateItemById(item.getId(), item);
        return "redirect:/bitlab-shop";
    }

    @PostMapping(value = "/bitlab-shop/delete")
    public String bitlabShopDelete(@RequestParam Long id) {
        DBManager.deleteItemById(id);
        return "redirect:/bitlab-shop";
    }

    @GetMapping(value = "/task-manager")
    public String taskManager(Model model) {
        model.addAttribute("tasks", DBManager.getAllTasks());
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

        DBManager.addTask(task);
        return "redirect:/task-manager";
    }

    @GetMapping(value = "/task-manager/details/{id}")
    public String taskManagerDetails(Model model, @PathVariable Long id) {
        model.addAttribute("task", DBManager.getTaskById(id));
        return "ch4/detail";
    }

    @PostMapping(value = "/task-manager/details")
    public String taskManagerDetailsUpdate(@RequestParam Long id, @RequestParam String name, 
        @RequestParam String description, @RequestParam String deadlineDate, @RequestParam String status) {

        Boolean completed = (status.equals("yes"));
        Task task = new Task(id, name, description, deadlineDate, completed);
        DBManager.updateTaskById(task.getId(), task);
        return "redirect:/task-manager";
    }

    @PostMapping(value = "/task-manager/delete/{id}")
    public String taskManagerDelete(@PathVariable Long id) {
        DBManager.deleteTaskById(id);
        return "redirect:/task-manager";
    }
    
}
