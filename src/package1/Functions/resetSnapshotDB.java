package package1.Functions;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class resetSnapshotDB {
	Connection connection = null;

	public void JDBCConnection() {
		try {
			connection = DriverManager
					.getConnection(
							"jdbc:oracle:thin:@ebsqa-scan.grc-network.net:1521/s_appdbtst",
							"SETUPSNAPSHOT", "APPTA7gSap");
			String jobquery = "DECLARE P_TENANT_ID NUMBER; BEGIN P_TENANT_ID := 1; K_GET_SNAPSHOT.P_FULL_RUN(P_TENANT_ID => P_TENANT_ID);END;";
			CallableStatement callStmt = connection.prepareCall(jobquery);
			callStmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String sqlQuery(String s)
	{
		String x = null;
		try {
			connection = DriverManager
					.getConnection(
							"jdbc:oracle:thin:@ebsqa-scan.grc-network.net:1521/s_appdbtst",
							"SETUPSNAPSHOT", "APPTA7gSap");
			Statement stmt = connection.createStatement();
            ResultSet rs;
 
            rs = stmt.executeQuery(s);
            x= rs.getString(1);
            rs.next();
            connection.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	
	}
	}

	


