package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MovieTable {
	private int movie_id;
	private String movie_name;
	private String release_year;
	  
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getRelease_year() {
		return release_year;
	}
	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}
	
	Connection con;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;
    
    public void insert() throws Exception {
    	this.con = JDBCConn.getConn();
        this.stmt = this.con.createStatement();
        this.pstmt = this.con.prepareStatement("INSERT INTO movie VALUES(?,?,?)");
//        This query will fetch movie name taking parameter as release year
        this.rs = this.stmt.executeQuery("SELECT movie_name as MOVIE_NAME , release_year AS YEAR_OF_RELEASE FROM movie ORDER BY release_year DESC;");
        if (this.rs.next())
          this.movie_id = this.rs.getInt(1); 
        this.movie_id++;
        this.pstmt.setInt(1, this.movie_id);
        this.pstmt.setString(2, this.movie_name);
        this.pstmt.setString(3, this.release_year);
        this.pstmt.executeUpdate();
      }
    
    public void update() throws Exception {
        this.con = JDBCConn.getConn();
        this.stmt = this.con.createStatement();
        this.stmt.executeUpdate("UPDATE movie SET movie_name='" + this.movie_name +"',release_year='" + this.release_year +"' where movie_id='" + this.movie_id + "'");
      }
    
    public void delete() throws Exception {
        this.con = JDBCConn.getConn();
        this.stmt = this.con.createStatement();
        this.stmt.executeUpdate("DELETE movie WHERE movie_id=" + this.movie_id);
      }
}
