package com.cointeam.coin.pojo.domain;

public class MyCollectText {
    private Integer id;

    private Integer diviceId;

    private Integer textId;

    private Long time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiviceId() {
        return diviceId;
    }

    public void setDiviceId(Integer diviceId) {
        this.diviceId = diviceId;
    }

    public Integer getTextId() {
        return textId;
    }

    public void setTextId(Integer textId) {
        this.textId = textId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", diviceId=").append(diviceId);
        sb.append(", textId=").append(textId);
        sb.append(", time=").append(time);
        sb.append("]");
        return sb.toString();
    }
}