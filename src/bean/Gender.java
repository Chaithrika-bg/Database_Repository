package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Gender {
	private int gender_id;
	private String gender;
	
	public int getGender_id() {
		return gender_id;
	}
	public void setGender_id(int gender_id) {
		this.gender_id = gender_id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	Connection con;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;
	
    public void insert() throws Exception {
    	this.con = JDBCConn.getConn();
        this.stmt = this.con.createStatement();
        this.pstmt = this.con.prepareStatement("INSERT INTO gender VALUES(?,?)");
        
//      This query is to fetch name, role gender based on person_id and gender_id
        this.rs = this.stmt.executeQuery("SELECT person_name,role,gender FROM person,gender WHERE person.person_id=gender.gender_id;");
        
        if (this.rs.next())
          this.gender_id = this.rs.getInt(1); 
        this.gender_id++;
        this.pstmt.setInt(1, this.gender_id);
        this.pstmt.setString(2, this.gender);
        this.pstmt.executeUpdate();
      }
    
    public void update() throws Exception {
        this.con = JDBCConn.getConn();
        this.stmt = this.con.createStatement();
        this.stmt.executeUpdate("UPDATE gender SET gender='" + this.gender +"' where gender_id='" + this.gender_id + "'");
      }
    
    public void delete() throws Exception {
        this.con = JDBCConn.getConn();
        this.stmt = this.con.createStatement();
        this.stmt.executeUpdate("DELETE gender WHERE gender_id=" + this.gender_id);
      }
    
}
