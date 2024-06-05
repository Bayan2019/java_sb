/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kz.bitlab.java_sb.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kz.bitlab.java_sb.entity.Item;
import kz.bitlab.java_sb.service.ItemService;

/**
 *
 * @author bayan
 */
@Service
public class ItemServiceImpl implements ItemService{

    private static ArrayList<Item> items = new ArrayList<>();
    private static Long id_items = 7L;

    static {
        items.add(new Item(1L, "Mac Book Pro", "8 GB RAM 255 GB SSD Intel Core i7", 1199.99, 10));
        items.add(new Item(2L, "Mac Book Pro", "16 GB RAM 500 GB SSD Apple M1", 1499.99, 10));
        items.add(new Item(3L, "Mac Book Pro", "16 GB RAM 1 TB SSD Apple M1", 1799.99, 10));
        items.add(new Item(4L, "ASUS Tuf Gaming", "16 GB RAM 500 GB SSD Intel Core i7", 1299.99, 15));
        items.add(new Item(5L, "HP Laser Pro", "8 GB RAM 500 GB SSD Intel Core i5", 999.99, 7));
        items.add(new Item(6L, "Lenovo Legion", "32 GB RAM 512 GB SSD Intel Core i7", 1399.99, 7));
    }

    @Override
    public ArrayList<Item> getAllItems() {
        return items;
    }

    @Override
    public void addItem(Item item) {
        item.setId(id_items);
        id_items++;
        items.add(item);
    }

    @Override
    public Item getItemById(Long id) {
        return items.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    @Override
    public int getItemIndex(Long id) {
        for (int i = 0; i < getAllItems().size(); i++) {
            if (getAllItems().get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void updateItemById(Long id, Item item) {
        items.set(getItemIndex(id), item);
    }

    @Override
    public void deleteItemById(Long id) {
        items.remove(getItemById(id));
    }
}
