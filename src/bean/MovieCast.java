package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MovieCast {
	private int movie_id;
	private int gender_id;
	private int person_id;
	private String character_name;
	
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public int getGender_id() {
		return gender_id;
	}
	public void setGender_id(int gender_id) {
		this.gender_id = gender_id;
	}
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public String getCharacter_name() {
		return character_name;
	}
	public void setCharacter_name(String character_name) {
		this.character_name = character_name;
	}
	
	Connection con;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;
    
    public void insert() throws Exception {
    	this.con = JDBCConn.getConn();
        this.stmt = this.con.createStatement();
        this.pstmt = this.con.prepareStatement("INSERT INTO movie_cast VALUES(?,?,?,?)");
        
//        This is the query to fetch the movie name based on person id
        this.rs = this.stmt.executeQuery("SELECT movie_name,person_name,role FROM movie,movie_cast,person WHERE person.person_id=movie_cast.movie_id;");
        
        this.pstmt.setInt(1, this.movie_id);
        this.pstmt.setInt(2, this.gender_id);
        this.pstmt.setInt(3, this.person_id); 
        this.pstmt.setString(4, this.character_name);
        this.pstmt.executeUpdate();
      }
    
    public void update() throws Exception {
        this.con = JDBCConn.getConn();
        this.stmt = this.con.createStatement();
        this.stmt.executeUpdate("UPDATE movie_cast SET movie_id='" + this.movie_id +"',gender_id='" + this.gender_id +"',person_id='" + this.person_id +"' where movie_id='" + this.movie_id + "'");
      }
    
    public void delete() throws Exception {
        this.con = JDBCConn.getConn();
        this.stmt = this.con.createStatement();
        this.stmt.executeUpdate("DELETE movie_cast WHERE movie_id=" + this.movie_id);
      }
    
}
