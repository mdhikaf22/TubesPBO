package com.example.pc_builder.controller;

import com.example.pc_builder.dto.ErrorResponse;
import com.example.pc_builder.dto.PCBuildDTO;
import com.example.pc_builder.models.PCBuild;
import com.example.pc_builder.models.PCBuildComponent;
import com.example.pc_builder.service.PCBuildComponentService;
import com.example.pc_builder.service.PCBuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pc-builds")
public class PCBuildController {
    private final PCBuildService pcBuildService;

    @Autowired
    public PCBuildController(PCBuildService pcBuildService) {
        this.pcBuildService = pcBuildService;
    }

    @PostMapping
    public PCBuild createPCBuild(@RequestBody PCBuild pcBuild) {
        return pcBuildService.createPCBuild(pcBuild);
    }

    @GetMapping
    public List<PCBuild> getAllPCBuilds() {
        return pcBuildService.getAllPCBuilds();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDetailPCBuild(@PathVariable Long id) {
        try {
            PCBuild pcBuild = pcBuildService.getPCBuildById(id);
            return ResponseEntity.ok(pcBuild);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Build not found"));
        }
    }

    @PutMapping("/{id}")
    public PCBuild updatePCBuild(@PathVariable Long id, @RequestBody PCBuild pcBuildDetails) {
        return pcBuildService.updatePCBuild(id, pcBuildDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePCBuild(@PathVariable Long id) {
        pcBuildService.deletePCBuild(id);
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<Object> getPCBuildsByPrice(@PathVariable Double price) {
        List<PCBuild> pcBuilds = pcBuildService.getPCBuildByPrice(price);
        if (pcBuilds.isEmpty()) {
            return ResponseEntity
                    .status(200)
                    .body(new ErrorResponse("Build not found for the specified price"));
        }

        return ResponseEntity.ok(pcBuilds);
    }

    @GetMapping("/search-by-budget")
    public List<PCBuildDTO> searchByBudget(
            @RequestParam Double minBudget,
            @RequestParam Double maxBudget
    ) {
        return pcBuildService.findBuildsByBudget(minBudget, maxBudget);
    }
}

