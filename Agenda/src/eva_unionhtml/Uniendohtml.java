package eva_unionhtml;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Uniendohtml {

	
	
	BufferedReader leefichero(String filename) {			
		
	    FileInputStream in = null;
	    
		try {
			in = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return new BufferedReader(new InputStreamReader(in));
	}

	
	
	public void main(String[] args) throws IOException {
	    // Open a file
	    BufferedReader myheader = leefichero("myheader.txt");
	    BufferedReader contents = leefichero("contentfile.txt");
	    BufferedReader footer = leefichero("footer.txt");

	    FileWriter mistream = new FileWriter("espai.html");
	    BufferedWriter out = new BufferedWriter(mistream);

	    out.write("<html>");
	    out.newLine();

	    for (String line = myheader.readLine(); line!=null; line = myheader.readLine()) {
	        out.write(line);
	        out.newLine(); 
	    }

	    for (String line = contents.readLine(); line!=null; line = contents.readLine()) {
	        out.write(line);
	        out.newLine(); 
	    }

	    
	    for (String line = footer.readLine(); line!=null; line = contents.readLine()) {
	        out.write(line);
	        out.newLine(); 
	    }

	    out.write("</html>");
	}

}
