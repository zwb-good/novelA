package com.lemon.pojo;

public class Setting {
    private Integer id;

    private Integer userId;

    private Integer fontSize;

    private String bgcColor;

    private String fontFamily;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public String getBgcColor() {
        return bgcColor;
    }

    public void setBgcColor(String bgcColor) {
        this.bgcColor = bgcColor == null ? null : bgcColor.trim();
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily == null ? null : fontFamily.trim();
    }
}