package com.pashkobohdan.allcontentinone.presentation.model.realm;

import com.pashkobohdan.allcontentinone.presentation.model.dto.SourceDTO;
import com.pashkobohdan.allcontentinone.presentation.model.enums.SourceType;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class SourceDTORealmObject extends RealmObject {
    @PrimaryKey
    private int id;

    @Ignore
    private SourceType sourceType;
    private String sourceTypeString;

    private String name;

    public SourceDTORealmObject() {
        //Default empty constructor
    }

    public SourceDTORealmObject(SourceType sourceType, String name) {
        this.sourceType = sourceType;
        setSourceTypeString(sourceType.name());
        this.name = name;
    }

    public SourceDTORealmObject(SourceDTO sourceDTO) {
        this.sourceType = sourceDTO.getSourceType();
        setSourceTypeString(sourceType.name());
        this.name = sourceDTO.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SourceType getSourceType() {
        return SourceType.valueOf(getSourceTypeString());
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
        setSourceTypeString(sourceType.name());
    }

    public String getSourceTypeString() {
        return sourceTypeString;
    }

    public void setSourceTypeString(String sourceTypeString) {
        this.sourceTypeString = sourceTypeString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
