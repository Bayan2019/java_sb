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
public class ApplicationRequest {
    private Long id;
    private String userName;
    private String courseName;
    private String commentary;
    private String phone;
    private boolean handled;
}
