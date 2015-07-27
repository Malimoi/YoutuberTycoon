package utilities;

public class Evenement {
	
	private Integer day;
	private Integer month;
	private Integer year;
	private Integer id;
	private Long data;
	
	public Long getData() {
		return data;
	}

	public Evenement(Integer day, Integer month, Integer year, Integer id, Long data){
		
		this.day=day;
		this.month=month;
		this.year=year;
		this.id=id;
		this.data=data;
		
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
