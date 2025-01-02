package com.example.pc_builder.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PC_Builds")
public class PCBuild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buildId;

    @Column(nullable = false)
    private String buildName;

    @Column(nullable = false)
    private Double totalPrice;

    @OneToMany(mappedBy = "pcBuild", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PCBuildComponent> components = new ArrayList<>();


    public void addComponent(PCBuildComponent component) {
        components.add(component);
        component.setPcBuild(this);
    }

    public void removeComponent(PCBuildComponent component) {
        components.remove(component);
        component.setPcBuild(null);
    }

    public List<PCBuildComponent> getComponents() {
        return components;
    }

    public void setBuildId(Long buildId) {
        this.buildId = buildId;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getBuildId() {
        return buildId;
    }

    public String getBuildName() {
        return buildName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
}
