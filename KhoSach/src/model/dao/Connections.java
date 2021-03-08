package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connections {
	public Connection cn;
	public void KetNoi()  {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dburl="jdbc:sqlserver://HIEULT\\SQLEXPRESS:1433;databaseName=KhoSach;user=sa;password=123";
				cn=DriverManager.getConnection(dburl);
			}catch(Exception ee) {
			ee.printStackTrace();
		}
	}
}
