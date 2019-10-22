package com.ems.pojo;

public class EmsUser {
    private Integer index1;

    private String uid;

    private String uname;

    private String upassword;

    private String utype;

    public Integer getIndex1() {
        return index1;
    }

    public void setIndex1(Integer index1) {
        this.index1 = index1;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword == null ? null : upassword.trim();
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype == null ? null : utype.trim();
    }

	@Override
	public String toString() {
		return "EmsUser [index1=" + index1 + ", uid=" + uid + ", uname=" + uname + ", upassword=" + upassword
				+ ", utype=" + utype + "]";
	}
    
}