package com.cnnic.whois.dao.base;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class BaseDao {
	
	protected QueryRunner queryRunner = new QueryRunner();
	
	/**
	 * add，delete，update Operation
	 */
	protected void update(Connection conn, String sql, Object[] params, String message){
		try {
			queryRunner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(message, e);
		}
	}
	
	@SuppressWarnings("unchecked")
	protected <T> List<T> getAllObject(Connection conn, String sql, Object[] params, String message,Class<T> clazz){
		List<T> list = new ArrayList<T>();
		try {
			list = (List<T>) queryRunner.query(conn, sql, params, new BeanListHandler(clazz));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(message, e);
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T getObject(Connection conn, String sql, Object[] params, String message,Class<T> clazz){
		T t = null;
		try {
			t = (T) queryRunner.query(conn, sql, params, new BeanHandler(clazz));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(message, e);
		}
		return t;
	}
	
}
