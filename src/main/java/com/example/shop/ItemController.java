package com.example.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;



    @GetMapping("/list")
    String list(Model model){
        List<Item> result = itemRepository.findAll();


        model.addAttribute("items",result);
        var a = new Item();
        System.out.println(a.toString());
        Item item = new Item();
        System.out.println(item.getTitle());
        return "list.html";
    }

    @GetMapping("/write")
    String write(){
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(String title, Integer price){
        itemService.saveItem(title, price);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model){


        System.out.println(id);
        Optional<Item> result = itemRepository.findById(id);
        if(result.isPresent()) {
            System.out.println(result.get());
            model.addAttribute("data",result.get());
            return "detail.html";
        } else{
            return "redirect:/list";
        }


    }

    @PostMapping("/edit")
    String editItem(String title, Integer price, Long id ){

        Item item = new Item();
        item.setId(id);
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);

        return "redirect:/list";

    }

    @GetMapping("/edit/{id}")
    String editItem(@PathVariable Long id, Model model){
        Optional<Item> result = itemRepository.findById(id);
        if(result.isPresent()) {
            model.addAttribute("data", result.get());
            return "edit.html";
        } else {
            return "redirect:/list";
        }
    }

    @GetMapping("/test1")
    String test1(){
        System.out.println("요청들어옴");
        return "redirect:/list";
    }

    @PostMapping("/test1")
    String test1(@RequestBody Map<String, Object> body){
        System.out.println(body);
        return "redirect:/list";
    }
}




