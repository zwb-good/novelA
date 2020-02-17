package com.lemon.pojo;

public class Book {
    private Integer id;

    private String name;

    private String author;

    private String url;

    private Integer novelTypeId;

    private String abstractText;
    
    private Noveltype noveltype;

    public Noveltype getNoveltype() {
		return noveltype;
	}

	public void setNoveltype(Noveltype noveltype) {
		this.noveltype = noveltype;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getNovelTypeId() {
        return novelTypeId;
    }

    public void setNovelTypeId(Integer novelTypeId) {
        this.novelTypeId = novelTypeId;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText == null ? null : abstractText.trim();
    }
}