package com.example.pc_builder.dto;

import java.util.List;

public class PCBuildDTO {
    private Long buildId;
    private String buildName;
    private Double totalPrice;
    private List<ComponentDTO> components;

    public PCBuildDTO(Long buildId, String buildName, Double totalPrice, List<ComponentDTO> components) {
        this.buildId = buildId;
        this.buildName = buildName;
        this.totalPrice = totalPrice;
        this.components = components;
    }

    public Long getBuildId() {
        return buildId;
    }

    public void setBuildId(Long buildId) {
        this.buildId = buildId;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ComponentDTO> getComponents() {
        return components;
    }

    public void setComponents(List<ComponentDTO> components) {
        this.components = components;
    }
}
