package com.lavneet.Persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lavneet.POJO.Student;
import com.lavneet.utility.JdbcUtil;


public class StudentDaoImpl implements IStudentDao 
{
	@Override
	public String save(com.lavneet.POJO.Student student)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try
		{
			connection = JdbcUtil.getDBConnection();
			if (connection!=null)
			{
				String SQL_INSERT_QUERY="INSERT INTO STUDENTDB (SID,SNAME,SAGE,SADDRESS) VALUES(?,?,?,?)";
				pstmt=connection.prepareStatement(SQL_INSERT_QUERY);
				if (pstmt!=null)
				{
					pstmt.setInt(1, student.getSid());
					pstmt.setString(2, student.getSname());
					pstmt.setInt(3, student.getSage());
					pstmt.setString(4, student.getSaddress());
					rowCount = pstmt.executeUpdate();
					if (rowCount>0)
					{
						return "Record Inserted Successfully!!!!...";
					}
					
				}
			}
		}
		catch(SQLException | IOException e)
		{
			e.printStackTrace();	
		}
		finally
		{
			JdbcUtil.close(null, pstmt, connection);
		}
		return "Record Insertion Failed Try Again!!.....";
		
	}

	@Override
	public Student getById(int id)
	{
		Connection connection =null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try
		{
			connection = JdbcUtil.getDBConnection();
			if(connection!=null)
			{
				String SQL_SELECT_QUERY = "SELECT SID,SNAME,SAGE,SADDRESS FROM STUDENTDB WHERE SID=?";
				pstmt = connection.prepareStatement(SQL_SELECT_QUERY);
				if(pstmt!=null)
				{
					pstmt.setInt(1, id);
					resultSet = pstmt.executeQuery();
					if(resultSet.next()) 
					{
						Student student = new Student();
						student.setSid(resultSet.getInt(1));
						student.setSname(resultSet.getString(2));
						student.setSage(resultSet.getInt(3));
						student.setSaddress(resultSet.getString(4));
						return student;
						
					}
				}
			}
		}
		catch(SQLException | IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			JdbcUtil.close(resultSet, pstmt, connection);
		}
		return null;
		
	}

	@Override
	public String updateById(com.lavneet.POJO.Student student) 
	{
		
		
		return null;
	}

	@Override
	public String deleteById(int id) 
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		int rowCount=0;
	
		try
		{
			connection = JdbcUtil.getDBConnection();
			if(connection!=null)
			{
				String SQL_DELETE_QUERY = "DELETE FROM STUDENTDB WHERE SID = ?";
				pstmt = connection.prepareStatement(SQL_DELETE_QUERY);
				if(pstmt!=null)
				{
					pstmt.setInt(1, id);
					rowCount= pstmt.executeUpdate();
					
					if(rowCount>0)
					{
						return "Record Deleted Successfully!!!....";
					}
				}
				
			}
		}
		catch(SQLException | IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			JdbcUtil.close(null, pstmt, connection);
		}
		return "Record Deletion Failed Try Again!!!....";
	}
	

}
