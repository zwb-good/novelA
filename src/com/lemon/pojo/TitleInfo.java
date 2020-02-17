package com.lemon.pojo;

public class TitleInfo {
	private int index;//章节下下标
    private String title;//章节标题
    private int startLength;//章节开始字节数，用来和RandomAccessFile作章节跳转和单章解析用
    private int endLength;//章节开始字节数，用来和RandomAccessFile作章节跳转和单章解析用

    public TitleInfo(){

    }

    public TitleInfo(int index, String title, int startLength,int endLength) {
        this.index = index;
        this.title = title;
        this.startLength = startLength;
        this.endLength = endLength;
    }

    public int getIndex() {
        return index;
    }

    public String getTitle() {
        return title;
    }

    public long getStartLength() {
        return startLength;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartLength(int startLength) {
        this.startLength = startLength;
    }
    

    public int getEndLength() {
		return endLength;
	}

	public void setEndLength(int endLength) {
		this.endLength = endLength;
	}

	public String toString(){
        return "[index = " + index  + ",title = " + title + ",startLength = " + startLength + ",endLength = " + endLength + "]";
    }
}
