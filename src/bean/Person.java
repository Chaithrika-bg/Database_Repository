package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Person {
	private int person_id;
	private String person_name;
	private String role;
	
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	Connection con;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;
    
    public void insert() throws Exception {
    	this.con = JDBCConn.getConn();
        this.stmt = this.con.createStatement();
        this.pstmt = this.con.prepareStatement("INSERT INTO person VALUES(?,?,?)");
        
//      This is to fetch the movie name, actor, actress, director, year of release       
        this.rs = this.stmt.executeQuery("SELECT movie_name,person_name,role,release_year FROM movie,person ");
        if (this.rs.next())
          this.person_id = this.rs.getInt(1); 
        this.person_id++;
        this.pstmt.setInt(1, this.person_id);
        this.pstmt.setString(2, this.person_name);
        this.pstmt.setString(3, this.role);
        this.pstmt.executeUpdate();
      }
    
    public void update() throws Exception {
        this.con = JDBCConn.getConn();
        this.stmt = this.con.createStatement();
        this.stmt.executeUpdate("UPDATE person SET person_name='" + this.person_name +"',role='" + this.role+"' where person_id='" + this.person_id + "'");
      }
    
    public void delete() throws Exception {
        this.con = JDBCConn.getConn();
        this.stmt = this.con.createStatement();
        this.stmt.executeUpdate("DELETE person WHERE person_id=" + this.person_id);
      }
}
