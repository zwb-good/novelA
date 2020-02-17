package com.lemon.pojo;

public class GuidePage {
    private Integer id;

    private String adTitle;

    private String adLeft;

    private String adRight;

    private Byte page;

    private String imgUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle == null ? null : adTitle.trim();
    }

    public String getAdLeft() {
        return adLeft;
    }

    public void setAdLeft(String adLeft) {
        this.adLeft = adLeft == null ? null : adLeft.trim();
    }

    public String getAdRight() {
        return adRight;
    }

    public void setAdRight(String adRight) {
        this.adRight = adRight == null ? null : adRight.trim();
    }

    public Byte getPage() {
        return page;
    }

    public void setPage(Byte page) {
        this.page = page;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }
}