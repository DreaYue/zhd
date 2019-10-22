package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ems.util.DBUtils;

public class TeacherDao {


	//教师批准学生请假信息
	public int qingjia(String pizhun, String uid) {
		Connection connection = null;
		PreparedStatement prsm = null;
		ResultSet reSet = null;
		DBUtils dbUtils = new DBUtils();
		int Rcount = 0;
		try {
			connection = dbUtils.getConn();
			// connection=dbUtils.getConn();
			// 创建statement对象
			// update 表名 set 修改列名=‘新值’，列名2=‘新值’where条件
			String sql = "update ems_leave set state=? where sid=?";
			Object obj[] = { pizhun, uid };
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

	
	//老师增加学生成绩
	public int addsc(String sid, String cid, String score) {
		Connection connection = null;
		PreparedStatement prsm = null;
		ResultSet reSet = null;
		DBUtils dbUtils = new DBUtils();
		int Rcount = 0;
		try {
			connection = dbUtils.getConn();
			// connection=dbUtils.getConn();
			// 创建statement对象
			String sql = "insert into ems_sc values (default,?,?,?)";
			Object obj[] = { sid, cid, score };
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
