package com.cointeam.coin.pojo.domain;

public class Text {
    private Integer id;

    private String title;

    private String author;

    private String content;

    private String picUrl;

    private Long time;

    private Integer type;

    private Long publicTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Long publicTime) {
        this.publicTime = publicTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", author=").append(author);
        sb.append(", content=").append(content);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", time=").append(time);
        sb.append(", type=").append(type);
        sb.append(", publicTime=").append(publicTime);
        sb.append("]");
        return sb.toString();
    }
}