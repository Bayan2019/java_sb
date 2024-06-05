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
public class Item {
    private Long id;
    private String name;
    private String description;
    private double price;
    int amount;
}
