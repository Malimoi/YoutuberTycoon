package utilities;

public class Evenement {

    private Integer day;
    private Integer month;
    private Integer year;
    private Integer id;

    public Evenement(Integer day, Integer month, Integer year, Integer id) {

        this.day = day;
        this.month = month;
        this.year = year;
        this.id = id;

    }

    public Integer getDay() {
        return day;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getId() {
        return id;
    }

}
