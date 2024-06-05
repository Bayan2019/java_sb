/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package kz.bitlab.java_sb.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kz.bitlab.java_sb.entity.Item;

/**
 *
 * @author bayan
 */
@Service
public interface ItemService {

    ArrayList<Item> getAllItems();

    void addItem(Item item);

    Item getItemById(Long id);

    int getItemIndex(Long id);

    void updateItemById(Long id, Item item);

    void deleteItemById(Long id);
}
