/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kz.bitlab.java_sb.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.bitlab.java_sb.model.Operator;
import kz.bitlab.java_sb.repository.OperatorRepository;
import kz.bitlab.java_sb.service.OperatorService;

/**
 *
 * @author bayan
 */
@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorRepository operatorRepository;

    @Override
    public ArrayList<Operator> getAllOperators() {
        return (ArrayList<Operator>) operatorRepository.findAll();
    }

    @Override
    public Operator getOperatorById(int id) {
        return operatorRepository.findById(id).orElse(null);
    }
}
