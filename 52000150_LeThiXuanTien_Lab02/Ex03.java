import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url1 = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "";
		try {
			Connection connection=DriverManager.getConnection(url1, user, password);
			Statement stm = (Statement) connection.createStatement();
			
			String sql = "select * from student";
			
			ResultSet data = stm.executeQuery(sql);
			
			ArrayList<Student> studentList = new ArrayList<Student>();
			
			while(data.next()) {
				String name = data.getString(1);
				int age = data.getInt(2);
				Student s = new Student(name, age);
				studentList.add(s);
			}
			
			for(Student s : studentList) {
				System.out.println(s);
			}
			connection.close();
			stm.close();
		} catch (Exception ex) {
		// TODO: handle exception
			System.out.println("An error occurred. Maybe user/password is invalid");
//		    ex.printStackTrace();
		}	
	}

}
