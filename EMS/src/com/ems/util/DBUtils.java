package com.ems.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * 工具类  连接数据库
 * 
 * @author lenovo
 *
 */
public class DBUtils {
	Connection connection=null;
	Statement statement=null;
	ResultSet reSet=null;
	PreparedStatement prsm=null;
	public Connection getConn() {
		
	try {
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//连接数据库  并且设置字符集编码是utf-8
		String url="jdbc:mysql://localhost:3306/ems?useUnicode=true&characterEncoding=UTF-8";
		String user="root";
		String password="root123";
		//获取数据库连接对象
		connection=DriverManager.getConnection(url, user, password);
	} catch (ClassNotFoundException e) {
		System.out.println("DBUtils->getConn(): 加载驱动失败");
		e.printStackTrace();
	}catch (SQLException e) {
		System.out.println("DBUtils->getConn(): 连接数据库失败");
		e.printStackTrace();
	}
	
	return connection;
  }
	//关闭资源
	public void closeAll(Connection connection,Statement statement,ResultSet reSet) {	
		try {
			if (reSet!=null) {
				reSet.close();
			}
			if (statement!=null) {
				statement.close();
			}
			if (connection!=null) {
				connection.close();
			}
			}catch (Exception e) {
				System.out.println("DBUtils->closeAll(Connection connection,Statement statement,ResultSet reSet):关闭资源失败");
				e.printStackTrace();
			}
	}
	
	//查询方法:
	public ResultSet query(String sql ,Object obj[]){
		
		try {

			//创建PrepareStatement对象
			prsm = connection.prepareStatement(sql);
			//obj数组不为空的值,给占位符赋值
			if(obj != null){
				for(int i=0;i<obj.length;i++){
					prsm.setObject(i+1, obj[i]);//给占位符赋值从1开始，obj[i]是指的数组的每个元素
				}
			}
			reSet= prsm.executeQuery();
			
		} catch (SQLException e) {
			System.out.println("DBUtils->query(String sql ,Object obj[]):查询语句出错");
			e.printStackTrace();
		}		
		return reSet;
	}

	//插入、修改、删除方法的封装:
	public int editSql(String sql ,Object obj[]){
		int count = 0;
		try {
			//创建PrepareStatement对象
			prsm = connection.prepareStatement(sql);
			//obj数组不为空的值,给占位符赋值
			if(obj != null){
				for(int i=0;i<obj.length;i++){
					prsm.setObject(i+1, obj[i]);
				}
			}
			
			count = prsm.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("DBUtils->editSql(String sql ,Object obj[]):SQL语句错误");
			e.printStackTrace();
		}
		
		return count;
	}
}