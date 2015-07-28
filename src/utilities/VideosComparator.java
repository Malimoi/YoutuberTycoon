package utilities;


import java.lang.Integer;
import java.lang.String;
import java.util.Comparator;

public class VideosComparator implements Comparator<String> {

    public int compare(String a, String b) {
        int aVal = 0, bVal = 0;
        
        if (Integer.parseInt(a.split("§")[3])!=Integer.parseInt(b.split("§")[3])){
        	aVal=Integer.parseInt(a.split("§")[3]);
        	bVal=Integer.parseInt(b.split("§")[3]);
        }else if (Integer.parseInt(a.split("§")[2])!=Integer.parseInt(b.split("§")[2])){
        	aVal=Integer.parseInt(a.split("§")[2]);
        	bVal=Integer.parseInt(b.split("§")[2]);
        }else if (Integer.parseInt(a.split("§")[1])!=Integer.parseInt(b.split("§")[1])){
        	aVal=Integer.parseInt(a.split("§")[1]);
        	bVal=Integer.parseInt(b.split("§")[1]);
        }

        return Integer.compare(aVal, bVal);
    }

}
