/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kz.bitlab.java_sb.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author bayan
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    private Long id;
    private String name;
    private String surname;
    private int exam;
    private String mark;

    public void setMark() {
        this.mark = "F";

        if (this.exam>=90) {
            this.mark = "A";
        } else if (this.exam>=75 && this.exam<90) {
            this.mark = "B";
        } else if (this.exam>=60 && this.exam<75) {
            this.mark = "C";
        } else if (this.exam>=50 && this.exam<59) {
            this.mark = "D";
        }
    }

    public Student(Long id, String name, String surname, int exam) {
        this.setId(id);
        this.setName(name);
        this.setSurname(surname);
        this.setExam(exam);
        this.setMark();
    }
}
