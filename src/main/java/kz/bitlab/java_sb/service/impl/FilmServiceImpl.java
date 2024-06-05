/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kz.bitlab.java_sb.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kz.bitlab.java_sb.entity.Film;
import kz.bitlab.java_sb.service.FilmService;

/**
 *
 * @author bayan
 */
@Service
public class FilmServiceImpl implements FilmService{

    private static ArrayList<Film> films = new ArrayList<>();
    private static Long id_films = 4L;

    static {
        films.add(new Film(1L, "Matrix", "About Neo", 2002, 8.8));
        films.add(new Film(2L, "Harry Potter", "About Harry Potter", 2001, 8.5));
        films.add(new Film(3L, "Duna", "About Maudib", 2023, 8.7));
    }

    @Override
    public ArrayList<Film> getAllFilms() {
        return films;
    }

    @Override
    public void addFilm(Film film) {
        film.setId(id_films);
        id_films++;
        films.add(film);
    }

}
