package com.cnnic.whois.dao.query.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.cnnic.whois.bean.QueryJoinType;
import com.cnnic.whois.bean.QueryParam;
import com.cnnic.whois.bean.QueryType;
import com.cnnic.whois.execption.QueryException;
import com.cnnic.whois.util.ColumnCache;
import com.cnnic.whois.util.WhoisUtil;

public class RegistrarQueryDao extends AbstractDbQueryDao {

	/**
	 * Connect to the database query variant information
	 * 
	 * @param queryInfo
	 * @param role
	 * @return map collection
	 * @throws QueryException
	 */
	public Map<String, Object> queryVariants(String queryInfo, String format)
			throws QueryException {
		Connection connection = null;
		Map<String, Object> map = null;

		try {
			connection = ds.getConnection();
			String selectSql = WhoisUtil.SELECT_LIST_VARIANTS + "'" + queryInfo
					+ "'";
			map = query(connection, selectSql, ColumnCache.getColumnCache()
					.getRegistrarKeyFileds(), "$mul$variants");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new QueryException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException se) {
				}
			}
		}
		return map;
	}

	@Override
	public QueryType getQueryType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supportType(QueryType queryType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> query(QueryParam param) throws QueryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean supportJoinType(QueryType queryType,
			QueryJoinType queryJoinType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object querySpecificJoinTable(String key, String handle,
			Connection connection) throws SQLException {
		return querySpecificJoinTable(key, handle,
				WhoisUtil.SELECT_JOIN_LIST_REGISTRAR, connection, ColumnCache
						.getColumnCache().getRegistrarKeyFileds());
	}
}
