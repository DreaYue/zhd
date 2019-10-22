package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ems.pojo.EmsCourse;
import com.ems.pojo.EmsLeave;
import com.ems.pojo.EmsUser;
import com.ems.util.DBUtils;

public class StudentDao {

	EmsUser use = null;
	Connection connection = null;
	PreparedStatement prsm = null;
	ResultSet reSet = null;
	DBUtils dbUtils = new DBUtils();

	// 用户登录:
	public EmsUser checkLogin(String userID, String pwd, String utype) {

		try {
			connection = dbUtils.getConn();
			String sql = "select * from ems_user where uid=? and upassword=? and utype=?";
			Object obj[] = { userID, pwd, utype };
			reSet = dbUtils.query(sql, obj);
			// 发送sql语句
			if (reSet.next()) {
				use = new EmsUser();
				String username = reSet.getNString("uname");
				String type = reSet.getNString("utype");
				String uid = reSet.getString("uid");
				use.setUname(username);
				use.setUid(uid);
				use.setUtype(type);
				use.setUpassword(pwd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭顺序由内到外，结果集→statement→connection
			dbUtils.closeAll(connection, prsm, reSet);
		}
		return use;
	}

	// 注册用户
	public int Resisterin(String userName, String pwd, String utype, String uid) {
		int Rcount = 0;
		try {
			connection = dbUtils.getConn();
			// connection=dbUtils.getConn();
			// 创建statement对象
			String sql = "insert into ems_user values (default,?,?,?,?)";
			Object obj[] = { userName, pwd, utype, uid };
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

	//学生查询课程表信息
	public List<EmsCourse> CourseQuery(String cTime) {

		List<EmsCourse> list = new ArrayList<EmsCourse>();

		// 调用getconn（）方法加载jdbc驱动，连接数据库
		connection = dbUtils.getConn();
		// 创建SQL语句
		String cQuerySql = "select * from ems_course where ctime=?";
		Object obj[] = { cTime };
		// 调用query方法查询数据库
		reSet = dbUtils.query(cQuerySql, obj);
		try {
			// 遍历结果集
			while (reSet.next()) {
				EmsCourse user = new EmsCourse();

				String cid = reSet.getString("cid");
				String cname = reSet.getString("cname");
				String cteacherID = reSet.getString("cteacherID");
				Integer cmaxnum = reSet.getInt("cmaxnum");
				Integer cnownum = reSet.getInt("cnownum");
				Integer cgrade = reSet.getInt("cgrade");
				String cno = reSet.getString("cno");
				String ctime = reSet.getString("ctime");
				user.setCid(cid);
				user.setCname(cname);
				user.setCteacherid(cteacherID);
				user.setCmaxnum(cmaxnum);
				user.setCnownum(cnownum);
				user.setCgrade(cgrade);
				user.setCno(cno);
				user.setCtime(ctime);
				list.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeAll(connection, prsm, reSet);
		}
		return list;
	}

	// 学生查询请假信息
	public List<EmsLeave> FindStudentLeave(int sid) {
		List<EmsLeave> list = new ArrayList<>();
		dbUtils.getConn();
		String sql = "select * from ems_leave WHERE sid = ?";
		Object obj[] = { sid };
		ResultSet rSet = dbUtils.query(sql, obj);
		try {
			while (rSet.next()) {
				EmsLeave leave = new EmsLeave();
				leave.setSid(rSet.getString("sid"));
				leave.setTid(rSet.getString("tid"));
				leave.setLtime(rSet.getString("ltime"));
				leave.setIreason(rSet.getString("ireason"));
				leave.setState(rSet.getInt("state"));
				list.add(leave);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			dbUtils.closeAll(connection, prsm, reSet);
		}
		return list;
	}

	// 学生申请请假
	public int shenqingin(String uid, String ireason, String tid, String date) {
		Connection connection = null;
		PreparedStatement prsm = null;
		ResultSet reSet = null;
		DBUtils dbUtils = new DBUtils();
		int Rcount = 0;
		try {
			connection = dbUtils.getConn();
			String sql = "insert into ems_leave values (default,?,?,?,0,?)";
			Object obj[] = { uid, ireason, tid, date };
			Rcount = dbUtils.editSql(sql, obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			dbUtils.closeAll(connection, prsm, reSet);
		}
		return Rcount;
	}

	// 修改密码
	public int checkUpdate(String npwd1, String uid, String pwd) {
		int count = 0;
		Connection connection = null;
		PreparedStatement prsm = null;
		ResultSet reSet = null;
		DBUtils dbUtils = new DBUtils();

		EmsUser user = checkLogin(uid, pwd, "1");

		if (user != null) {

			try {
				connection = dbUtils.getConn();
				String sql = "update ems_user set upassword=? where  uid=?  ";
				Object obj[] = { npwd1, uid };
				count = dbUtils.editSql(sql, obj);

			} finally {
				// 关闭顺序由内到外，结果集→statement→connection
				dbUtils.closeAll(connection, prsm, reSet);
			}

		} else {
			return 10;   //表示ID与原密码不匹配。
		}
		return count;
	}

}
