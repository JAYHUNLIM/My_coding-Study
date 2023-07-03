import java.io.File;

public class DelTEST {

	public static void main(String[] args) {
		
		try {
		File file = new File(args[0]);
		
		 if (file.exists()) {	
			 if (file.delete()) {
			System.out.println("deleted");
		} else {
			System.out.println("deletion fail");
		}
		}else {
			System.out.println("file not found");
		}
		
		}catch (Exception e) {
			System.out.println("deletion fail"+e);
			
		}
		
		
		
		
		
	}
		

}
