package com.lemon.pojo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Comment {
    private Integer id;

    private Integer userId;

    private Integer bookId;

    private String content;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;

    private Integer likes;

    private Integer comments;
    
    private Reader reader;
    
    private Book book;
    
    private List<Replaycomment> replaycomment;
    
    private Reader readerFirst;
    
    private Reader toReader;
    

    public Reader getToReader() {
		return toReader;
	}

	public void setToReader(Reader toReader) {
		this.toReader = toReader;
	}

	public List<Replaycomment> getReplaycomment() {
		return replaycomment;
	}

	public void setReplaycomment(List<Replaycomment> replaycomment) {
		this.replaycomment = replaycomment;
	}

	public Reader getReaderFirst() {
		return readerFirst;
	}

	public void setReaderFirst(Reader readerFirst) {
		this.readerFirst = readerFirst;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

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

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }
}