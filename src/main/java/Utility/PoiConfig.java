package Utility;

import java.sql.*;

public class PoiConfig {
	static Connection con= null;
	
	public static Connection makeConnection(String WorkBook) throws Exception {
		Class.forName("com.googlecode.sqlsheet.Driver");
		con = DriverManager.getConnection("jdbc:xls:file:"+WorkBook);
		return con;
		
	}
	
	public static Object[][] getData(String WorkBook,String Sheet) throws Exception {
		con=makeConnection(WorkBook);
		Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery("select * from "+Sheet);
		ResultSetMetaData rsmt= rs.getMetaData();
		int colCount=rsmt.getColumnCount();
		rs.last();
		int rowCount=rs.getRow();
		rs.beforeFirst();
		Object data[][]=new Object[rowCount][colCount];
		for (int row=1;row<=rowCount;row++) {
			for(int col=1;col<=colCount;col++) {
				rs.absolute(row);
				String Data1=rs.getString(col);
				data[row-1][col-1]=Data1;
			}
		}
		return data;
		
	}
	public void closeConnection() throws SQLException
	{
		con.close();
	}
}
