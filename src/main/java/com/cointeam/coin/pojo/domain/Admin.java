package com.cointeam.coin.pojo.domain;

public class Admin {
    private Integer id;

    private Integer deviceId;

    private String userName;

    private String password;

    private Long activeTime;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Long activeTime) {
        this.activeTime = activeTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", activeTime=").append(activeTime);
        sb.append("]");
        return sb.toString();
    }
}