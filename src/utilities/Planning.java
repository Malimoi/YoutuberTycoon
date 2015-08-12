package utilities;

public class Planning{
	
	private Integer hour;
	private Integer hour_start;
	private Integer day;
	private Integer month;
	private Integer year;
	private Integer id;
	private Long data;
	private Long UUID;
	
	public Planning(Integer hour_start, Integer hour, Integer day, Integer month, Integer year, Integer id, Long data, Long UUID){
		
		this.hour=hour;
		this.hour_start=hour_start;
		this.day=day;
		this.month=month;
		this.year=year;
		this.id=id;
		this.data=data;
		this.UUID=UUID;
		
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public void setHour_start(Integer hour_start) {
		this.hour_start = hour_start;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Long getUUID() {
		return UUID;
	}

	public Integer getHour() {
		return hour;
	}

	public Long getData() {
		return data;
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
