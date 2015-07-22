package utilities;
import java.util.Calendar;


public class Planning{
	
	private Integer hour;
	private Integer hour_start;
	private Integer day;
	private Integer month;
	private Integer year;
	private Integer id;
	
	public Planning(Integer hour_start, Integer hour, Integer day, Integer month, Integer year, Integer id){
		
		this.hour=hour;
		this.hour_start=hour_start;
		this.day=day;
		this.month=month;
		this.year=year;
		this.id=id;
		
	}

	public Integer getHour() {
		return hour;
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

	public Integer getHour_start() {
		return hour_start;
	}

}