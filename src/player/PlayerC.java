package player;

public class PlayerC implements Player{
	
	private String pseudo;
	private long views;
	private long subscribers;
	private long dollars;
	/*
	 *	0=null;1=lundi/mardi/jeudi/vendredi;2=lundi/mardi/mercredi/jeudi/vendredi;3=lundi/mardi/mercredi/jeudi/vendredi/samedi;
	 *	4=lundi/mardi/mercredi/jeudi/vendredi/samedi/dimanche;
	 */
	private Integer work;
	private Integer salaire;
	private Integer lvl_animations_films, lvl_animaux, lvl_divertissement, lvl_gaming, lvl_humour, lvl_makeup_mode, lvl_musique,
		lvl_sciences, lvl_sport, lvl_cuisine, lvl_montage, lvl_ecriture, lvl_post_prod;
	private long exp_animations_films, exp_animaux, exp_divertissement, exp_gaming, exp_humour, exp_makeup_mode, exp_musique, exp_sciences, exp_sport, exp_cuisine,
		exp_montage, exp_ecriture, exp_post_prod;
	
	public PlayerC(String pseudo, long views, long subscribers, long dollars, Integer work, Integer salaire, 
			Integer lvl_animations_films, long exp_animations_films, Integer lvl_animaux, long exp_animaux, Integer lvl_divertissement, long exp_divertissement, 
			Integer lvl_gaming, long exp_gaming, Integer lvl_humour, long exp_humour, Integer lvl_makeup_mode, long exp_makeup_mode, Integer lvl_musique, 
			long exp_musique, Integer lvl_sciences, long exp_sciences, Integer lvl_sport, long exp_sport, Integer lvl_cuisine, long exp_cuisine, 
			Integer lvl_montage, long exp_montage, Integer lvl_ecriture, long exp_ecriture, Integer lvl_post_prod, long exp_post_prod){
		
		this.pseudo=pseudo;
		this.views=views;
		this.subscribers=subscribers;
		this.dollars=dollars;
		this.lvl_animations_films=lvl_animations_films;
		this.exp_animations_films=exp_animations_films;
		this.lvl_animaux=lvl_animaux;
		this.exp_animaux=exp_animaux;
		this.lvl_divertissement=lvl_divertissement;
		this.exp_divertissement=exp_divertissement;
		this.lvl_gaming=lvl_gaming;
		this.exp_gaming=exp_gaming;
		this.lvl_humour=lvl_humour;
		this.exp_humour=exp_humour;
		this.lvl_makeup_mode=lvl_makeup_mode;
		this.exp_makeup_mode=exp_makeup_mode;
		this.lvl_musique=lvl_musique;
		this.exp_musique=exp_musique;
		this.lvl_sciences=lvl_sciences;
		this.exp_sciences=exp_sciences;
		this.lvl_sport=lvl_sport;
		this.exp_sport=exp_sport;
		this.lvl_cuisine=lvl_cuisine;
		this.exp_cuisine=exp_cuisine;
		this.lvl_montage=lvl_montage;
		this.exp_montage=exp_montage;
		this.lvl_ecriture=lvl_ecriture;
		this.exp_ecriture=exp_ecriture;
		this.lvl_post_prod=lvl_post_prod;
		this.exp_post_prod=exp_post_prod;
		this.work=work;
		
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public void setViews(long views) {
		this.views = views;
	}

	public void setSubscribers(long subscribers) {
		this.subscribers = subscribers;
	}

	public void setDollars(long dollars) {
		this.dollars = dollars;
	}

	public void setWork(Integer work) {
		this.work = work;
	}

	public void setSalaire(Integer salaire) {
		this.salaire = salaire;
	}

	public void setLvl_animations_films(Integer lvl_animations_films) {
		this.lvl_animations_films = lvl_animations_films;
	}

	public void setLvl_animaux(Integer lvl_animaux) {
		this.lvl_animaux = lvl_animaux;
	}

	public void setLvl_divertissement(Integer lvl_divertissement) {
		this.lvl_divertissement = lvl_divertissement;
	}

	public void setLvl_gaming(Integer lvl_gaming) {
		this.lvl_gaming = lvl_gaming;
	}

	public void setLvl_humour(Integer lvl_humour) {
		this.lvl_humour = lvl_humour;
	}

	public void setLvl_makeup_mode(Integer lvl_makeup_mode) {
		this.lvl_makeup_mode = lvl_makeup_mode;
	}

	public void setLvl_musique(Integer lvl_musique) {
		this.lvl_musique = lvl_musique;
	}

	public void setLvl_sciences(Integer lvl_sciences) {
		this.lvl_sciences = lvl_sciences;
	}

	public void setLvl_sport(Integer lvl_sport) {
		this.lvl_sport = lvl_sport;
	}

	public void setLvl_cuisine(Integer lvl_cuisine) {
		this.lvl_cuisine = lvl_cuisine;
	}

	public void setLvl_montage(Integer lvl_montage) {
		this.lvl_montage = lvl_montage;
	}

	public void setLvl_ecriture(Integer lvl_ecriture) {
		this.lvl_ecriture = lvl_ecriture;
	}

	public void setLvl_post_prod(Integer lvl_post_prod) {
		this.lvl_post_prod = lvl_post_prod;
	}

	public void setExp_animations_films(long exp_animations_films) {
		this.exp_animations_films = exp_animations_films;
	}

	public void setExp_animaux(long exp_animaux) {
		this.exp_animaux = exp_animaux;
	}

	public void setExp_divertissement(long exp_divertissement) {
		this.exp_divertissement = exp_divertissement;
	}

	public void setExp_gaming(long exp_gaming) {
		this.exp_gaming = exp_gaming;
	}

	public void setExp_humour(long exp_humour) {
		this.exp_humour = exp_humour;
	}

	public void setExp_makeup_mode(long exp_makeup_mode) {
		this.exp_makeup_mode = exp_makeup_mode;
	}

	public void setExp_musique(long exp_musique) {
		this.exp_musique = exp_musique;
	}

	public void setExp_sciences(long exp_sciences) {
		this.exp_sciences = exp_sciences;
	}

	public void setExp_sport(long exp_sport) {
		this.exp_sport = exp_sport;
	}

	public void setExp_cuisine(long exp_cuisine) {
		this.exp_cuisine = exp_cuisine;
	}

	public void setExp_montage(long exp_montage) {
		this.exp_montage = exp_montage;
	}

	public void setExp_ecriture(long exp_ecriture) {
		this.exp_ecriture = exp_ecriture;
	}

	public void setExp_post_prod(long exp_post_prod) {
		this.exp_post_prod = exp_post_prod;
	}

	public String getPseudo() {
		return pseudo;
	}

	public long getViews() {
		return views;
	}

	public long getSubscribers() {
		return subscribers;
	}

	public long getDollars() {
		return dollars;
	}

	public Integer getWork() {
		return work;
	}

	public Integer getSalaire() {
		return salaire;
	}

	public Integer getLvl_animations_films() {
		return lvl_animations_films;
	}

	public Integer getLvl_animaux() {
		return lvl_animaux;
	}

	public Integer getLvl_divertissement() {
		return lvl_divertissement;
	}

	public Integer getLvl_gaming() {
		return lvl_gaming;
	}

	public Integer getLvl_humour() {
		return lvl_humour;
	}

	public Integer getLvl_makeup_mode() {
		return lvl_makeup_mode;
	}

	public Integer getLvl_musique() {
		return lvl_musique;
	}

	public Integer getLvl_sciences() {
		return lvl_sciences;
	}

	public Integer getLvl_sport() {
		return lvl_sport;
	}

	public Integer getLvl_cuisine() {
		return lvl_cuisine;
	}

	public Integer getLvl_montage() {
		return lvl_montage;
	}

	public Integer getLvl_ecriture() {
		return lvl_ecriture;
	}

	public Integer getLvl_post_prod() {
		return lvl_post_prod;
	}

	public long getExp_animations_films() {
		return exp_animations_films;
	}

	public long getExp_animaux() {
		return exp_animaux;
	}

	public long getExp_divertissement() {
		return exp_divertissement;
	}

	public long getExp_gaming() {
		return exp_gaming;
	}

	public long getExp_humour() {
		return exp_humour;
	}

	public long getExp_makeup_mode() {
		return exp_makeup_mode;
	}

	public long getExp_musique() {
		return exp_musique;
	}

	public long getExp_sciences() {
		return exp_sciences;
	}

	public long getExp_sport() {
		return exp_sport;
	}

	public long getExp_cuisine() {
		return exp_cuisine;
	}

	public long getExp_montage() {
		return exp_montage;
	}

	public long getExp_ecriture() {
		return exp_ecriture;
	}

	public long getExp_post_prod() {
		return exp_post_prod;
	}
	
}
