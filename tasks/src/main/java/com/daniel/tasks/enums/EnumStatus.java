package com.daniel.tasks.enums;

public enum EnumStatus {
    PENDING("PED", "Pending"),
    DONE("DON", "Done");

    private String code;
    private String description;

    private EnumStatus(final String code, final String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
