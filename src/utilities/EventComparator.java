package utilities;

import java.util.Comparator;

public class EventComparator implements Comparator<Evenement>{

	@Override
	public int compare(Evenement o1, Evenement o2) {
		int aVal = 0, bVal = 0;
        
        if (o1.getYear()!=o2.getYear()){
        	aVal=o1.getYear();
        	bVal=o2.getYear();
        }else if (o1.getMonth()!=o2.getMonth()){
        	aVal=o1.getMonth();
        	bVal=o2.getMonth();
        }else if (o1.getDay()!=o2.getDay()){
        	aVal=o1.getDay();
        	bVal=o2.getDay();
        }

        return Integer.compare(aVal, bVal);
	}

}
