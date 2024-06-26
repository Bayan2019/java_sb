/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kz.bitlab.java_sb.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author bayan
 */
@Entity
@Table(name="application_requests")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="username")
    private String userName;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;
    
    @Column(name="commentary", columnDefinition="text")
    private String commentary;
    @Column(name="phone")
    private String phone;
    @Column(name="handled")
    private boolean handled;

    @ManyToOne
    private List<Operator> operators = new ArrayList<>();
}
