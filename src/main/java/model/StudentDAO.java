package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.StudentBean;
import bean.StudentDTO;


public class StudentDAO {
	private final String URL="jdbc:mysql://localhost:3306/sampledb";
	private final String USER="root";
	private final String PASS="";

	
	private Connection con=null;
	
	
	public void connect(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(URL,USER,PASS);
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	
	public StudentDTO select() {
		Statement stmt=null;
		ResultSet rs=null;
		StudentDTO sdto=new StudentDTO();
		String sql="select *from student";
		
		try {
			connect();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				StudentBean sb=new StudentBean();
				sb.setNo(rs.getInt("no"));
				sb.setName(rs.getString("name"));
				sb.setScore(rs.getInt("score"));
				sdto.add(sb);
			}
		}catch(Exception e) {
			e.getStackTrace();
		}finally{
			try {
				if(rs!=null) {
					rs.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			}catch(Exception e) {
				e.getStackTrace();
			}
		}
		disconnect();
		return sdto;
	}
	
	
	public int insert(int no,String name,int score) {
		String sql="insert into student values("+no+",'"+name+"',"+score+")";
		return executeSql(sql);
	}
	
	public int update(int no,String name,int score) {
		String sql="update student set no="+no+",name='"+name+"',score="+score+" where no="+no;
		return executeSql(sql);
	}
	
	public int delete(int no) {
		String sql="delete from student where no="+no;
		return executeSql(sql);
	}
	
	
	public int executeSql(String sql) {
		Statement stmt=null;
		ResultSet rs=null;
		int result=0; 
		try {
			connect();
			stmt=con.createStatement();
			result=stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.getStackTrace();
		}finally{
			try {
				if(rs!=null) {
					rs.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			}catch(Exception e) {
				e.getStackTrace();
			}
		}
		disconnect();
		return result;
	}
	
	
	public void disconnect(){
		try {
			if(con!=null) {
				con.close();
			}
			
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	
}
