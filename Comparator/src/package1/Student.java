package package1;

import java.util.ArrayList;
import java.util.Comparator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Collections;

public class Student {

	private final String name; //last, first
	private final Date enrollment_date; //date object
	
	/**
	 * constructor for Student
	 * @param Name is the nameof the student
	 * @param whenEnrolled is the dateof the student being enrolled
	 * @precondition date must be simpleDateFormat
	 * @precondition name must of type string
	 */
	Student(String Name, Date whenEnrolled){
		enrollment_date = whenEnrolled;
		name = Name;
	}
	/**
	 * 
	 * @return the name of the student
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * 
	 * @return the date of the student
	 */
	public Date getDate()
	{
		return enrollment_date;
	}
	/**
	 * 
	 * @return a comparator with sorted list by names is returned
	 */
	public static Comparator<Student> getCompByName( )
	{
		Comparator<Student> comp = new Comparator<Student>(){

			public int compare(Student arg0, Student arg1) {
				
				return arg0.getName().compareTo(arg1.getName());
			}
			
		};
		return comp;
	}
	/**
	 * 
	 * @return a comparator with sorted list by date is returned
	 */
	public static Comparator<Student> getCompByDate()
	{
		Comparator<Student> comp = new Comparator<Student>(){

			@Override
			public int compare(Student arg0, Student arg1) {
				
				return arg0.getDate().compareTo(arg1.getDate());
			}
			
		};
		return comp;
	}
	public static void main(String[] args) throws ParseException
	{
		ArrayList<Student> list = new ArrayList(); //arrayList for type student
		
		SimpleDateFormat df = new SimpleDateFormat("MM/d/yy"); //format for the date
		Date a1 = df.parse("02/12/1999");  
		Date a2 = df.parse("05/5/1877");
		Date a3 = df.parse("07/7/1988");
		Date a4 = df.parse("12/28/2000");
		
		Student s1 = new Student("Mike", a1); //creating 4 student objects with name and date
		Student s2 = new Student("Dan", a2);
		Student s3 = new Student("Paul", a3);
		Student s4 = new Student("Ash", a4);
		
		list.add(s1);  //adding objects to list
		list.add(s2);
		list.add(s3);
		list.add(s4);
		
		for(int i = 0; i<list.size(); i++)
		{
			System.out.println(list.get(i).name);
		}
		
		Collections.sort(list, Student.getCompByName());  //sorting by name
		System.out.println("\n");
		for(int i = 0; i<list.size(); i++)
		{
			System.out.println(list.get(i).name);
		}
		System.out.println("\n");
		Collections.sort(list, Student.getCompByDate()); //sorting by date
		for(int i = 0; i<list.size(); i++)
		{
			System.out.println(list.get(i).name+ " " +list.get(i).enrollment_date);
		}
	}
}
