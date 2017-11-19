package com.pashkobohdan.allcontentinone.presentation.model.enums;

public enum SourceType {
    VK("vk", "vk.com"),
    IDEER("ideer", "ideer.com");

    private String defaultName;
    private String address;

    SourceType(String defaultName, String address) {
        this.defaultName = defaultName;
        this.address = address;
    }

    public String getName() {
        return defaultName;
    }

    public String getAddress() {
        return address;
    }
}
