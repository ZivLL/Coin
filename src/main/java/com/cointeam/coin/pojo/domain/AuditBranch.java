package com.cointeam.coin.pojo.domain;

public class AuditBranch {
    private Integer id;

    private Integer deviceId;

    private Integer cardId;

    private String content;

    private Integer type;

    private Integer status;

    private Long time;

    private Long submitTimes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getSubmitTimes() {
        return submitTimes;
    }

    public void setSubmitTimes(Long submitTimes) {
        this.submitTimes = submitTimes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", cardId=").append(cardId);
        sb.append(", content=").append(content);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", time=").append(time);
        sb.append(", submitTimes=").append(submitTimes);
        sb.append("]");
        return sb.toString();
    }
}