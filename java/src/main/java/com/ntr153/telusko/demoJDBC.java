package com.ntr153.telusko;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class demoJDBC {
    public static void main(String[] args) throws SQLException {

        /* 
         * Steps -
         * 1. Import Packages
         * 2. Load Driver
         * 3. Register Driver
         * 4. Create Connection
         * 5. Create Statement
         * 6. Execute Statement
         * 7. Close Connection
         */

        /* Basic JDBC connection and Usage - */

        String url = "jdbc:oracle:thin:@localhost:1522/xe";     // jdbc:connector://location:portNumber/SID_or_service_name
                                                                //XEPDB1 -  this was original database name from oracle
        String userName = "C##NTR153";
        String password = "0000";

        /* Admin Access (because create session was not working)
        String adminUserName = "SYSTEM";
        Connection adminCon = DriverManager.getConnection(url, adminUserName, password); // Establish connection using appropriate credentials
        Statement adminStmt = adminCon.createStatement();
        adminStmt.execute("GRANT CREATE SESSION TO C##NTR153");
        adminStmt.close();
        adminCon.close(); // Close the administrative connection
        */

        /*
        String sql = "select * from student order by s_id";

        // Class.forName("org.postgresql.Driver"); // (load and register driver) was
        // needed in previous versions
        Connection con = DriverManager.getConnection(url, userName, password); // (create connection)

        Statement st = con.createStatement(); // (create statement)
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.print(rs.getInt(1) + " - "); // gets output based on column index
            System.out.print(rs.getString(2) + " - ");
            System.out.println(rs.getInt(3));
        }

        st.close();
        con.close(); // (close connection)

        */

        /* Using Prepared Statement */

        int sid = 6;
        String sname = "Max";
        int marks = 50;

        String sql = "insert into student values (?,?,?)";

        Connection con = DriverManager.getConnection(url, userName, password);

        PreparedStatement st = con.prepareStatement(sql);        // uses cache storing facility so that sql statement is not called every time
                                                                 // only binding variables are transferred
        st.setInt(1, sid);
        st.setString(2, sname);
        st.setInt(3, marks);

        st.execute();

        con.close();
    }
}
