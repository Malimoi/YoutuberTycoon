package utilities;
import java.util.List;


public class Videos {
	
	private String name;
	private Long views;
	private Long likes;
	private Long dislikes;
	private Long share;
	private List<String> comments;
	private Long ID;
	
	public Videos (String name, Long views, Long likes, Long dislikes, Long share, List<String> comments, Long ID){
		
		this.name=name;
		this.views=views;
		this.likes=likes;
		this.dislikes=dislikes;
		this.share=share;
		this.comments=comments;
		this.ID=ID;
		
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

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public void addComments(String s) {
		this.comments.add(s);
	}
	
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

}
