package com.example.pc_builder.service;

import com.example.pc_builder.models.Component;
import com.example.pc_builder.repositories.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentService {

    @Autowired
    private ComponentRepository componentRepository;

    public Component createComponent(Component component) {
        return componentRepository.save(component);
    }

    public List<Component> getAllComponents() {
        return componentRepository.findAll();
    }

    public Component getComponentById(Long id) {
        return componentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Component not found"));
    }

    public Component updateComponent(Long id, Component componentDetails) {
        Component component = getComponentById(id);
        component.setName(componentDetails.getName());
        component.setCategory(componentDetails.getCategory());
        component.setPrice(componentDetails.getPrice());
        return componentRepository.save(component);
    }

    public void deleteComponent(Long id) {
        componentRepository.deleteById(id);
    }
}
