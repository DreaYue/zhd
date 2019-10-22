package com.ems.pojo;

public class EmsCourse {
    private Integer dex;

    private String cid;

    private String cname;

    private String cteacherid;

    private Integer cmaxnum;

    private Integer cnownum;

    private Integer cgrade;

    private String cno;

    private String ctime;

    public Integer getDex() {
        return dex;
    }

    public void setDex(Integer dex) {
        this.dex = dex;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCteacherid() {
        return cteacherid;
    }

    public void setCteacherid(String cteacherid) {
        this.cteacherid = cteacherid == null ? null : cteacherid.trim();
    }

    public Integer getCmaxnum() {
        return cmaxnum;
    }

    public void setCmaxnum(Integer cmaxnum) {
        this.cmaxnum = cmaxnum;
    }

    public Integer getCnownum() {
        return cnownum;
    }

    public void setCnownum(Integer cnownum) {
        this.cnownum = cnownum;
    }

    public Integer getCgrade() {
        return cgrade;
    }

    public void setCgrade(Integer cgrade) {
        this.cgrade = cgrade;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno == null ? null : cno.trim();
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }
}