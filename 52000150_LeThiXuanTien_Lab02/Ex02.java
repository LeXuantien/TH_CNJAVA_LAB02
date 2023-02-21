import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;



public class Ex02 {

	public static void main(String[] args) {
		String url1 = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "";
		try {
			Connection connection=DriverManager.getConnection(url1, user, password);
			
//			String sql = "Create table student(name nvarchar(30) primary key, age int)";
//			Statement stm = (Statement) connection.createStatement();
//			stm.executeUpdate(sql);
			
			String s = "insert into student values(?, ?)";
			PreparedStatement ptm = (PreparedStatement) connection.prepareStatement(s);
			
			ptm.setString(1, "XuanTien");
			ptm.setInt(2, 20);
			
			int rows = ptm.executeUpdate();
			
			if(rows==1) {
				System.out.println("Them thanh cong");
			}
			
//			stm.close();
			connection.close();
			ptm.close();
		} catch (Exception ex) {
		// TODO: handle exception
			System.out.println("An error occurred. Maybe user/password is invalid");
//		    ex.printStackTrace();
		}	
		
		
	}

}
