package Test;

import java.util.List;

import com.neuedu.bean.Student;
import com.neuedu.bean.studentDao;

public class test {

	public static void main(String[] args) {
		studentDao dao = new studentDao();
		//查
		List<Student> students = dao.getStudents();
		for(Student student :students) {
			System.out.println(student);
		}
		//增
		/*Student student = new Student();
		student.setName("Jmaes");
		student.setBId(4);
		student.setGerden(1);
		int result = dao.add(student);
		System.out.println("受影响的行数" + result);*/
		
		//改
		/*Student student = new Student();
		student.setName("curry");
		student.setBId(1);
		student.setGerden(0);
		student.setId(3);
		int result = dao.update(student);
		System.out.println("受影响的行数" + result);
        */
		//删
//		Student student = new Student();
//		
//		int result = dao.delete(3);
//		System.out.println("受影响的行数" + result);
		
	}

}
