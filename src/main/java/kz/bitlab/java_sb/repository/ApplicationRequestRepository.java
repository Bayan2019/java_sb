/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package kz.bitlab.java_sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kz.bitlab.java_sb.model.ApplicationRequest;

/**
 *
 * @author bayan
 */
@Repository
@Transactional
public interface ApplicationRequestRepository extends JpaRepository<ApplicationRequest, Long> {
    
}
