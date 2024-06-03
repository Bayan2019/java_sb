package kz.bitlab.java_sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kz.bitlab.java_sb.db.DBManager;
import kz.bitlab.java_sb.db.Film;
import kz.bitlab.java_sb.db.Item;
import kz.bitlab.java_sb.db.Student;


@Controller
public class Home {

    @GetMapping(value="/")
    public String mainPage(Model model) {
        model.addAttribute("films", DBManager.getAlFilms());
        return "main";
    }

    @PostMapping(value = "/add-film")
    public String addFilm(Film film) {
        DBManager.addFilm(film);
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
    
}
