package com.example.pc_builder.controller;

import com.example.pc_builder.models.PCBuildComponent;
import com.example.pc_builder.service.PCBuildComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pc-build-components")
public class PCBuildComponentController {
    private final PCBuildComponentService pcBuildComponentService;

    @Autowired
    public PCBuildComponentController(PCBuildComponentService pcBuildComponentService) {
        this.pcBuildComponentService = pcBuildComponentService;
    }

    @PostMapping
    public PCBuildComponent createPCBuildComponent(@RequestBody PCBuildComponent pcBuildComponent) {
        return pcBuildComponentService.createPCBuildComponent(pcBuildComponent);
    }

    @GetMapping
    public List<PCBuildComponent> getAllPCBuildComponents() {
        return pcBuildComponentService.getAllPCBuildComponents();
    }

    @PutMapping("/{id}")
    public PCBuildComponent updatePCBuildComponent(@PathVariable Long id, @RequestBody PCBuildComponent pcBuildComponentDetails) {
        return pcBuildComponentService.updatePCBuildComponent(id, pcBuildComponentDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePCBuildComponent(@PathVariable Long id) {
        pcBuildComponentService.deletePCBuildComponent(id);
    }
}

