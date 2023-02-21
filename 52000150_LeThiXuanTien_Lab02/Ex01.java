import java.sql.Connection;
import java.sql.DriverManager;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// connect way #1
		String url1 = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "";
		try {
			Connection connection=DriverManager.getConnection(url1, user, password);
			System.out.println("ket noi thanh cong");
			connection.close();
		} catch (Exception ex) {
		// TODO: handle exception
			System.out.println("An error occurred. Maybe user/password is invalid");
//		    ex.printStackTrace();
		}	
	}

}
