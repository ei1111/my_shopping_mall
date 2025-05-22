package com.web.item.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/items")
public class ItemViewController {
    @GetMapping("/new")
    public String saveForm() {
        return "items/createItemForm";
    }

    @GetMapping
    public String itemListForm() {
        return "items/itemList";
    }

    @GetMapping("/{itemId}/edit")
    public String updateForm(@PathVariable Long itemId, Model model) {
        model.addAttribute("itemId", itemId);
        return "items/updateItemForm";
    }
}
