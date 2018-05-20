package com.tutorials4u.ibatis;

import java.io.IOException;
import java.io.Reader;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class IbatisUtil {
	private SqlMapClient sqlmapClient;

	public IbatisUtil() {
	}

	public static SqlMapClient initateSqlMapClient() {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("sql-maps-config.xml");
			SqlMapClient sqlmapClient = SqlMapClientBuilder
					.buildSqlMapClient(reader);
			return sqlmapClient;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
