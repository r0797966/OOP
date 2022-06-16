package domain;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class StudentGroep implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String naam;
	private ArrayList <Student> studenten;
	
	public StudentGroep(String naam) {
		this.naam = naam;
		studenten = new ArrayList<>();
	}
	
		
	public void voegStudentToe(Student student) {
		studenten.add(student);
	}
	
	@Override
	public String toString() {
		String out = "Groep: "+naam+"\n";
		for (Student student:studenten){
			out+=student+"\n";
		}
		return out;
	}
	
	public void save() {
		try{
	         FileOutputStream fos= new FileOutputStream("src/studenten.ser");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(this);
	         oos.close();
	         fos.close();
	         System.out.println("hallo");
	       }catch(IOException ioe){
	            System.out.println(ioe.getMessage());
	        }
	}
	
	public static StudentGroep load() {
		StudentGroep groep = null;
		try
		{
			FileInputStream fis = new FileInputStream("src/studenten.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
		    groep = (StudentGroep) ois.readObject();
			ois.close();
			fis.close();
		}catch(IOException ioe){
			 System.out.println(ioe.getMessage());
			
		}catch(ClassNotFoundException c){
			System.out.println("Class not found");
			c.printStackTrace();
			
		}
		return groep;
	}

}
