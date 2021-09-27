package com.cointeam.coin.pojo.domain;

public class MyShare {
    private Integer id;

    private Integer deviceId;

    private Integer type;

    private Integer auditCardId;

    private Integer auditBranchId;

    private Long time;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAuditCardId() {
        return auditCardId;
    }

    public void setAuditCardId(Integer auditCardId) {
        this.auditCardId = auditCardId;
    }

    public Integer getAuditBranchId() {
        return auditBranchId;
    }

    public void setAuditBranchId(Integer auditBranchId) {
        this.auditBranchId = auditBranchId;
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
        sb.append(", deviceId=").append(deviceId);
        sb.append(", type=").append(type);
        sb.append(", auditCardId=").append(auditCardId);
        sb.append(", auditBranchId=").append(auditBranchId);
        sb.append(", time=").append(time);
        sb.append("]");
        return sb.toString();
    }
}