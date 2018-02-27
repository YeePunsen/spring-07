package Test;

import java.util.List;

import com.neuedu.bean.Student;
import com.neuedu.bean.studentDao;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		studentDao dao =new studentDao();
		List<Student> students = dao.getStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
