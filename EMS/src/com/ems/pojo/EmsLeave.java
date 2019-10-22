package com.ems.pojo;

public class EmsLeave {
    private Integer dex;

    private String sid;

    private String ireason;

    private String tid;

    private Integer state;

    private String ltime;

    public Integer getDex() {
        return dex;
    }

    public void setDex(Integer dex) {
        this.dex = dex;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getIreason() {
        return ireason;
    }

    public void setIreason(String ireason) {
        this.ireason = ireason == null ? null : ireason.trim();
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getLtime() {
        return ltime;
    }

    public void setLtime(String ltime) {
        this.ltime = ltime == null ? null : ltime.trim();
    }
}