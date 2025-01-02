package com.example.pc_builder.service;

import com.example.pc_builder.models.PCBuildComponent;
import com.example.pc_builder.repositories.PCBuildComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PCBuildComponentService {

    @Autowired
    private PCBuildComponentRepository pcBuildComponentRepository;

    public PCBuildComponent createPCBuildComponent(PCBuildComponent pcBuildComponent) {
        return pcBuildComponentRepository.save(pcBuildComponent);
    }

    public List<PCBuildComponent> getAllPCBuildComponents() {
        return pcBuildComponentRepository.findAll();
    }

    public PCBuildComponent getPCBuildComponentById(Long id) {
        return pcBuildComponentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PC Build Component not found"));
    }

    public PCBuildComponent updatePCBuildComponent(Long id, PCBuildComponent pcBuildComponentDetails) {
        PCBuildComponent pcBuildComponent = getPCBuildComponentById(id);
        pcBuildComponent.setQuantity(pcBuildComponentDetails.getQuantity());
        return pcBuildComponentRepository.save(pcBuildComponent);
    }

    public void deletePCBuildComponent(Long id) {
        pcBuildComponentRepository.deleteById(id);
    }
}
