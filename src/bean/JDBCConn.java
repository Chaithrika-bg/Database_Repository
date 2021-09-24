package bean;

import java.sql.DriverManager;
import java.sql.Connection;

public class JDBCConn
{
    public static Connection getConn() throws Exception {
        Class.forName(JDBCInfo.DRIVER);
        return DriverManager.getConnection(JDBCInfo.URL, JDBCInfo.USER, JDBCInfo.PASS);
    }
}