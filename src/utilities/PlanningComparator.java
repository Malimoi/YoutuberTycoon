package utilities;

import java.util.Comparator;

public class PlanningComparator implements Comparator<Planning>{

	@Override
	public int compare(Planning o2, Planning o1) {
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
        }else if (o1.getHour_start()!=o2.getHour_start()){
        	aVal=o1.getHour_start();
        	bVal=o2.getHour_start();
        }

        return Integer.compare(aVal, bVal);
	}

}
