package utilities;

import accessoires.Accessoire;

public class Video {
	
	private String name;
	private String author;
	private Integer day;
	private Integer month;
	private Integer year;
	private String last_change;
	private Long views;
	private Long likes;
	private Long dislikes;
	private String videogenre;
	private Boolean buzzpoint;
	private Integer longueur; /* 1->mini : 2->très-courte : 3->courte : 4->moyenne : 5->longue : 6->très-longue : 7->Enorme */
	private Accessoire camera;
	private Accessoire micro;
	private Accessoire ordinateur_gaming;
	private Accessoire ordinateur_montage;
	private Integer EcritureTime;
	private Integer TournageTime;
	private Integer MontageTime;
	private Integer PostprodTime;
	private Integer EcritureRemain;
	private Integer TournageRemain;
	private Integer MontageRemain;
	private Integer PostprodRemain;
	private Integer MontageQualite;
	private Integer ImageQualite;
	private Integer EcritureQualite;
	private Integer JeuQualite;
	private Long share;
	private Long ID;
	
	public Video (String name, String author, Integer day, Integer month, Integer year, String last_change, Long views, Long likes, Long dislikes, 
			String videogenre, Boolean buzzpoint, Integer longueur, Accessoire camera, Accessoire micro, Accessoire ordi, Accessoire ordi_mon, Integer EcritureTime,
			Integer TournageTime, Integer MontageTime, Integer PostprodTime, Integer EcritureRemain, Integer TournageRemain,
			Integer MontageRemain, Integer PostprodRemain, Integer MontageQualite, Integer ImageQualite, 
			Integer EcritureQualite, Integer JeuQualite, Long share, Long ID){
		
		this.day=day;
		this.month=month;
		this.year=year;
		this.name=name;
		this.author=author;
		this.last_change=last_change;
		this.views=views;
		this.likes=likes;
		this.dislikes=dislikes;
		this.share=share;
		this.videogenre=videogenre;
		this.buzzpoint=buzzpoint;
		this.longueur=longueur;
		this.camera=camera;
		this.micro=micro;
		this.ordinateur_gaming=ordi;
		this.ordinateur_montage=ordi_mon;
		this.EcritureTime=EcritureTime;
		this.TournageTime=TournageTime;
		this.MontageTime=MontageTime;
		this.PostprodTime=PostprodTime;
		this.EcritureRemain=EcritureRemain;
		this.TournageRemain=TournageRemain;
		this.MontageRemain=MontageRemain;
		this.PostprodRemain=PostprodRemain;
		this.MontageQualite=MontageQualite;
		this.ImageQualite=ImageQualite;
		this.EcritureQualite=EcritureQualite;
		this.JeuQualite=JeuQualite;
		this.ID=ID;
		
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLast_change() {
		return last_change;
	}

	public void setLast_change(String last_change) {
		this.last_change = last_change;
	}

	public Integer getEcritureRemain() {
		return EcritureRemain;
	}

	public void setEcritureRemain(Integer ecritureRemain) {
		EcritureRemain = ecritureRemain;
	}

	public Integer getTournageRemain() {
		return TournageRemain;
	}

	public void setTournageRemain(Integer tournageRemain) {
		TournageRemain = tournageRemain;
	}

	public Integer getMontageRemain() {
		return MontageRemain;
	}

	public void setMontageRemain(Integer montageRemain) {
		MontageRemain = montageRemain;
	}

	public Integer getPostprodRemain() {
		return PostprodRemain;
	}

	public void setPostprodRemain(Integer postprodRemain) {
		PostprodRemain = postprodRemain;
	}

	public Accessoire getCamera() {
		return camera;
	}

	public void setCamera(Accessoire camera) {
		this.camera = camera;
	}

	public Accessoire getMicro() {
		return micro;
	}

	public void setMicro(Accessoire micro) {
		this.micro = micro;
	}

	public Accessoire getOrdinateurGaming() {
		return ordinateur_gaming;
	}

	public void setOrdinateurGaming(Accessoire ordinateur_gaming) {
		this.ordinateur_gaming = ordinateur_gaming;
	}

	public Accessoire getOrdinateurMontage() {
		return ordinateur_montage;
	}

	public void setOrdinateurMontage(Accessoire ordinateur_montage) {
		this.ordinateur_montage = ordinateur_montage;
	}

	public Integer getLongueur() {
		return longueur;
	}

	public void setLongueur(Integer longueur) {
		this.longueur = longueur;
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
	
	public Integer getEcritureTime() {
		return EcritureTime;
	}

	public void setEcritureTime(Integer ecritureTime) {
		EcritureTime = ecritureTime;
	}

	public Integer getTournageTime() {
		return TournageTime;
	}

	public void setTournageTime(Integer tournageTime) {
		TournageTime = tournageTime;
	}

	public Integer getMontageTime() {
		return MontageTime;
	}

	public void setMontageTime(Integer montageTime) {
		MontageTime = montageTime;
	}

	public Integer getPostprodTime() {
		return PostprodTime;
	}

	public void setPostprodTime(Integer postprodTime) {
		PostprodTime = postprodTime;
	}

	public Integer getMontageQualite() {
		return MontageQualite;
	}

	public void setMontageQualite(Integer montageQualite) {
		MontageQualite = montageQualite;
	}

	public Integer getImageQualite() {
		return ImageQualite;
	}

	public void setImageQualite(Integer imageQualite) {
		ImageQualite = imageQualite;
	}

	public Integer getEcritureQualite() {
		return EcritureQualite;
	}

	public void setEcritureQualite(Integer ecritureQualite) {
		EcritureQualite = ecritureQualite;
	}

	public Integer getJeuQualite() {
		return JeuQualite;
	}

	public void setJeuQualite(Integer jeuQualite) {
		JeuQualite = jeuQualite;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Boolean getBuzzpoint() {
		return buzzpoint;
	}

	public void setBuzzpoint(Boolean buzzpoint) {
		this.buzzpoint = buzzpoint;
	}

}
