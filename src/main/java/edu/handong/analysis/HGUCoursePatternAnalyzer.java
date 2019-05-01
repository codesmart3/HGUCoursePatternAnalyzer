package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	int numOfStudents;
	int numOfCourses;
	Student[] students;
	Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		int length = numOfStudents;
		int i = 0, j = 0;
		
		students = new Student[length];
		Student duplicateChecker = new Student("null");
		
		/*Array initialization*/
		for(i = 0; i < length; i++) {
			students[i] = new Student("empty");
		}
		
		for(i = 0; i < lines.length; i++) {
			if(j > 2)
			{
				j--;
			}
			
			duplicateChecker = new Student(lines[i].split(", ")[1]);
			
			if(!studentExist(students, duplicateChecker)){
			students[j] =  new Student(lines[i].split(", ")[1]);
			j++;
		}				
			}
		
		
		return students;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		
		// TODO: implement this method

		int i = 0;
		int length = students.length;
		
		for(i = 0; i < length; i++) {

			if(students[i].getName().equals(student.getName())) {
				return true;
				}
			}
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		int length = numOfCourses;
		int i = 0, j = 0;
		
		courses = new Course[length];
		Course duplicateChecker = new Course("null");
		
		/*Array initialization*/
		for(i = 0; i < length; i++) {
			courses[i] = new Course("empty");
		}
		
		for(i = 0; i < lines.length; i++) {
			if(j > 5) {
				j--;
			}
			duplicateChecker = new Course(lines[i].split(", ")[2]);
			
			if(!courseExist(courses, duplicateChecker)) {
			courses[j] = new Course(lines[i].split(", ")[2]);
				j++;
			}
		}
		return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		// TODO: implement this method
		int i = 0;
		
		for(i = 0; i < courses.length; i++) {
			if(courses[i].getCourseName().equals(course.getCourseName())) {
				return true;
			}
		}
		return false;
	}

}
