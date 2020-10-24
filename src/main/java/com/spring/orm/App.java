package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import javax.print.DocFlavor.INPUT_STREAM;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.dao.StudentDaoImpl;
import com.spring.orm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = (StudentDao) context.getBean("studentDao");
  /*     Student student = new Student(789,"miku","Rhel");
       int r = studentDao.insert(student);
       System.out.println("done :"+ r);  */
        System.out.println("******************WelCome**************************");
        BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
        boolean go = true;
        while (go) {
        System.out.println("Press 1 for add new Student");
        System.out.println("Press 2 for display all Students");
        System.out.println("Press 3 for get details of Single Student");
        System.out.println("Press 4 for delete");
        System.out.println("Press 5 for Update");
        System.out.println("Press 6 for Exit");
        try {
			int input = Integer.parseInt(br.readLine()); //after this we can use if and ifelese or switch.
			switch (input) {
			case 1:
				//insert student by taking input from user
				System.out.println("Enter Student Id");
				int sId = Integer.parseInt(br.readLine());
				System.out.println("Enter Student Name");
				String sName = br.readLine();
				System.out.println("Enter Student City");
				String sCity = br.readLine();
				//create student object and seting value
				Student student = new Student(sId,sName,sCity);
				//saving student object to database by calling insert method of studentdao class
				int r = studentDao.insert(student);
				System.out.println("Student added :"+r);
				System.out.println("***********************************************");
				System.out.println();
				
				break;
			case 2:
				//display all student
				System.out.println("***********************************************");
				List<Student> allStudents = studentDao.getAllStudents();
				for (Student st : allStudents) {
					System.out.println("Id :"+st.getStudentId());
					System.out.println("Name :"+st.getStudentName());
					System.out.println("city :"+st.getStudentCity());
					System.out.println("------------------------------");
				}
				System.out.println("***********************************************");
				break;
			case 3:
				//display single Student
				System.out.println("Enter Student Id");
				int studentId = Integer.parseInt(br.readLine());
				Student student2 = studentDao.getStudent(studentId);
				System.out.println("Id :"+student2.getStudentId());
				System.out.println("Name :"+student2.getStudentName());
				System.out.println("city :"+student2.getStudentCity());
				System.out.println("------------------------------");
				break;
			case 4:
				//delete
				System.out.println("Enter Student Id");
				int studentId2 = Integer.parseInt(br.readLine());
				studentDao.deleteStudent(studentId2);
				System.out.println("Student deleted");
				break;
			case 5:
				//update
				System.out.println("Enter Student Id");
				int usId = Integer.parseInt(br.readLine());
				System.out.println("Enter Student Name");
				String usName = br.readLine();
				System.out.println("Enter Student City");
				String usCity = br.readLine();
				//create student object and seting value
				Student student5 = new Student(usId,usName,usCity);
				studentDao.updateStudent(student5);
				System.out.println("updated Succesfuly");
				System.out.println("***********************************************");
				System.out.println();
				break;
			case 6:
				//Exit
				go = false;
				break;
			}
        	
        	
		} catch (Exception e) {
			System.out.println("Invalid input try with another one!!");
			System.out.println(e.getMessage());
		}
        
        }
       System.out.println("Thanku for Using MY App See you Soon"); 
        
        
        
        
        
        
    }
}
