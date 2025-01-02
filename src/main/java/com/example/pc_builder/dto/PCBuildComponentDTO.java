package com.example.pc_builder.dto;

import lombok.Data;

@Data
public class PCBuildComponentDTO {
    private Long id;
    private Long pcBuildId;
    private Long componentId;
    private Integer quantity;
}
