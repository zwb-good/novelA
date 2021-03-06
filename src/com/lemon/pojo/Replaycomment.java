package com.lemon.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Replaycomment {
    private Integer id;

    private Integer commentId;

    private Integer userId;

    private String content;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;

    private Integer likes;
    
    private Comment comment;
    
    private Reader reader;
    
    private Integer toUserId;
    
    private Integer replayId;
    
    private Reader toReader;
    
    private Replaycomment beforeReplay;
    
    private Integer state;

    public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Replaycomment getBeforeReplay() {
		return beforeReplay;
	}

	public void setBeforeReplay(Replaycomment beforeReplay) {
		this.beforeReplay = beforeReplay;
	}

	public Reader getToReader() {
		return toReader;
	}

	public void setToReader(Reader toReader) {
		this.toReader = toReader;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public Integer getToUserId() {
		return toUserId;
	}

	public void setToUserId(Integer toUserId) {
		this.toUserId = toUserId;
	}

	public Integer getReplayId() {
		return replayId;
	}

	public void setReplayId(Integer replayId) {
		this.replayId = replayId;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}