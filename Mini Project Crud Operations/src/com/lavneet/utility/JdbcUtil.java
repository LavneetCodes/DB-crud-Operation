package com.lavneet.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.DriverManager;

public class JdbcUtil 
{
	public static Connection getDBConnection() throws SQLException, IOException
	{
		String filepath="C:\\Users\\DeLL\\Advanced_Java-Workspace\\BLOB Operations\\src\\com\\resources\\connectionData.properties";
		FileInputStream fis = new FileInputStream(filepath);
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("jdbc.url");
		String username = p.getProperty("jdbc.username");
		String pwd = p.getProperty("jdbc.password");
		return DriverManager.getConnection(url, username, pwd);
	}
	public static void close(ResultSet resultset, Statement statement, Connection connection)
	{
		try
		{
			if (resultset !=null)
			{
				resultset.close();
			}
		}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		
			try
			{
				if (statement!=null)
				{
					statement.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			try
			{
				if(connection!=null)
				{
					connection.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
		
	}

}
