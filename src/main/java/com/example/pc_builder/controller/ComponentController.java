package com.example.pc_builder.controller;

import com.example.pc_builder.models.Component;
import com.example.pc_builder.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/components")
public class ComponentController {
    private final ComponentService componentService;

    @Autowired
    public ComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

    @PostMapping
    public Component createComponent(@RequestBody Component component) {
        return componentService.createComponent(component);
    }

    @GetMapping
    public List<Component> getAllComponents() {
        return componentService.getAllComponents();
    }

    @PutMapping("/{id}")
    public Component updateComponent(@PathVariable Long id, @RequestBody Component componentDetails) {
        return componentService.updateComponent(id, componentDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteComponent(@PathVariable Long id) {
        componentService.deleteComponent(id);
    }
}