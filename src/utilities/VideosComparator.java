package utilities;


import java.lang.Integer;
import java.lang.String;
import java.util.Comparator;

public class VideosComparator implements Comparator<Video> {

	@Override
	public int compare(Video v1, Video v2) {
		int aVal = 0, bVal = 0;
        
        if (v1.getYear()!=v2.getYear()){
        	int BONUS = 1000;
        	aVal=v1.getYear()!=0?v1.getYear():v1.getYear()+BONUS;
        	bVal=v2.getYear()!=0?v2.getYear():v2.getYear()+BONUS;
        }else if (v1.getMonth()!=v2.getMonth()){
        	aVal=v1.getMonth();
        	bVal=v2.getMonth();
        }else if (v1.getDay()!=v2.getDay()){
        	aVal=v1.getDay();
        	bVal=v2.getDay();
        }

        return Integer.compare(aVal, bVal);
	}

}
