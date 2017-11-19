package com.pashkobohdan.allcontentinone.presentation.model.dto;

import com.pashkobohdan.allcontentinone.presentation.model.dto.common.CommonDTO;
import com.pashkobohdan.allcontentinone.presentation.model.enums.SourceType;

import io.realm.annotations.PrimaryKey;

public class SourceDTO extends CommonDTO {
    @PrimaryKey
    private int id;

    private SourceType sourceType;
    private String name;

    public SourceDTO() {
        //Default empty constructor
    }

    public SourceDTO(SourceType sourceType, String name) {
        this.sourceType = sourceType;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }
}
