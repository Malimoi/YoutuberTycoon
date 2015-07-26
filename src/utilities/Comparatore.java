package utilities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Comparatore {
	
	public Comparatore(ArrayList<String> data){
		Collections.sort(data, new Comparator<String>() {
			   public int compare(String a, String b) {
			    int aVal = Integer.parseInt(a.split(" ")[1]);
			    int bVal = Integer.parseInt(b.split(" ")[1]);

			    return Integer.compare(aVal, bVal);
			   }
			  });
		Collections.reverse(data);
	}

}
