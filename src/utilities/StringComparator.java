package utilities;

import java.lang.Integer;
import java.lang.String;
import java.util.Comparator;

public class StringComparator implements Comparator<String> {

    public int compare(String a, String b) {
        int aVal = Integer.parseInt(a.split(" ")[1]),
                bVal = Integer.parseInt(b.split(" ")[1]);

        return Integer.compare(aVal, bVal);
    }

}
