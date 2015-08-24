package utilities;

import accessoires.Accessoire;

public class Video {
	
	private String name;
	private Integer day;
	private Integer month;
	private Integer year;
	private Long views;
	private Long likes;
	private Long dislikes;
	private String videogenre;
	private Integer longueur; /* 1->mini : 2->très-courte : 3->courte : 4->moyenne : 5->longue : 6->très-longue : 7->Enorme */
	private Accessoire camera;
	private Accessoire micro;
	private Accessoire ordinateur;
	private Integer EcritureTime;
	private Integer TournageTime;
	private Integer MontageTime;
	private Integer PostprodTime;
	private Integer fait;
	private Integer MontageQualite;
	private Integer ImageQualite;
	private Integer EcritureQualite;
	private Integer JeuQualite;
	private Long share;
	private Long ID;
	
	public Video (String name, Integer day, Integer month, Integer year, Long views, Long likes, Long dislikes, Long share,
			String videogenre, Integer longueur, Accessoire camera, Accessoire micro, Accessoire ordi, Integer EcritureTime,
			Integer TournageTime, Integer MontageTime, Integer fait, Integer PostprodTime, Integer MontageQualite, Integer ImageQualite, 
			Integer EcritureQualite, Integer JeuQualite, Long ID){
		
		this.day=day;
		this.month=month;
		this.year=year;
		this.name=name;
		this.views=views;
		this.likes=likes;
		this.dislikes=dislikes;
		this.share=share;
		this.videogenre=videogenre;
		this.longueur=longueur;
		this.camera=camera;
		this.micro=micro;
		this.ordinateur=ordi;
		this.EcritureTime=EcritureTime;
		this.TournageTime=TournageTime;
		this.MontageTime=MontageTime;
		this.PostprodTime=PostprodTime;
		this.fait=fait;
		this.MontageQualite=MontageQualite;
		this.ImageQualite=ImageQualite;
		this.EcritureQualite=EcritureQualite;
		this.JeuQualite=JeuQualite;
		this.ID=ID;
		
	}

	public Integer getFait() {
		return fait;
	}

	public void setFait(Integer fait) {
		this.fait = fait;
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

	public Accessoire getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Accessoire ordinateur) {
		this.ordinateur = ordinateur;
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

}
