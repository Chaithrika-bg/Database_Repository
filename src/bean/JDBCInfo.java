package bean;

public class JDBCInfo
{
    public static String DRIVER;
    public static String URL;
    public static String USER;
    public static String PASS;
    
    static {
        JDBCInfo.DRIVER = "com.mysql.cj.jdbc.Driver";
        JDBCInfo.URL = "jdbc:mysql://localhost:3306/movie_database";
        JDBCInfo.USER = "root";
        JDBCInfo.PASS = "xyz";
    }
}