package kz.bitlab.java_sb.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Film {

    private Long id;
    private String name;
    private String description;
    private int year;
    private double rating;
}
