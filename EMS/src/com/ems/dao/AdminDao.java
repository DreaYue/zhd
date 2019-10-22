package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ems.util.DBUtils;

public class AdminDao {


	//管理员新增课程信息
	public int addcourse(String cid, String cname,String cteacherID,int cmaxnum,int cnownum,int cgrade,String ctime) {
		Connection connection = null;
		PreparedStatement prsm = null;
		ResultSet reSet = null;
		DBUtils dbUtils = new DBUtils();
		int Rcount = 0;
		try {
			connection = dbUtils.getConn();
			// connection=dbUtils.getConn();
			// 创建statement对象
			String sql = "insert into ems_course values (default,?,?,?,?,?,?,default,?)";
			Object obj[] = { cid, cname,cteacherID,cmaxnum,cnownum,cgrade,ctime };
			Rcount = dbUtils.editSql(sql, obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭顺序由内到外，结果集→statement→connection
			dbUtils.closeAll(connection, prsm, reSet);
		}
		return Rcount;
	}

}
