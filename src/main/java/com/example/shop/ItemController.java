package com.example.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;
//    @Autowired
//    public ItemController(ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//    }

    @GetMapping("/list")
    String list(Model model){
        List<Item> result = itemRepository.findAll();
//        System.out.println(result.get(0).price);
//        System.out.println(result.get(0).title);

//        var a = new ArrayList<>();
//        a.add(30);
//        a.add(40);
//        System.out.println(a.get(0));


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
}
