package utilities;

public class Video {
	
	private String name;
	private Integer day;
	private Integer month;
	private Integer year;
	private Long views;
	private Long likes;
	private Long dislikes;
	private String videogenre;
	private Long share;
	
	private Long ID;
	
	public Video (String name, Integer day, Integer month, Integer year, Long views, Long likes, Long dislikes, Long share,
			String videogenre, Long ID){
		
		this.day=day;
		this.month=month;
		this.year=year;
		this.name=name;
		this.views=views;
		this.likes=likes;
		this.dislikes=dislikes;
		this.share=share;
		this.videogenre=videogenre;
		this.ID=ID;
		
	}

	public String getVideogenre() {
		return videogenre;
	}

	public void setVideogenre(String videogenre) {
		this.videogenre = videogenre;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getViews() {
		return views;
	}

	public void setViews(Long views) {
		this.views = views;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	public Long getDislikes() {
		return dislikes;
	}

	public void setDislikes(Long dislikes) {
		this.dislikes = dislikes;
	}

	public Long getShare() {
		return share;
	}

	public void setShare(Long share) {
		this.share = share;
	}
	
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

}
