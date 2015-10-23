package player;

public interface Player {
	
	public void setPseudo(String pseudo);
	
	public void setTheme(String theme);

	public void setViews(long views);

	public void setSubscribers(long subscribers);

	public void setDollars(long dollars);

	public void setWork(Integer work);

	public void setSalaire(Integer salaire);

	public void setLvl_animations_films(Integer lvl_animations_films);

	public void setLvl_divertissement(Integer lvl_divertissement);

	public void setLvl_gaming(Integer lvl_gaming);

	public void setLvl_humour(Integer lvl_humour);

	public void setLvl_makeup_mode(Integer lvl_makeup_mode);

	public void setLvl_musique(Integer lvl_musique);

	public void setLvl_sciences(Integer lvl_sciences);

	public void setLvl_sport(Integer lvl_sport);

	public void setLvl_cuisine(Integer lvl_cuisine);

	public void setLvl_montage(Integer lvl_montage);

	public void setLvl_ecriture(Integer lvl_ecriture);

	public void setLvl_post_prod(Integer lvl_post_prod);

	public void setExp_animations_films(long exp_animations_films);

	public void setExp_divertissement(long exp_divertissement);

	public void setExp_gaming(long exp_gaming);

	public void setExp_humour(long exp_humour);

	public void setExp_makeup_mode(long exp_makeup_mode);

	public void setExp_musique(long exp_musique);

	public void setExp_sciences(long exp_sciences);

	public void setExp_sport(long exp_sport);

	public void setExp_cuisine(long exp_cuisine);

	public void setExp_montage(long exp_montage);

	public void setExp_ecriture(long exp_ecriture);

	public void setExp_post_prod(long exp_post_prod);
	
	public String getPseudo();
	
	public String getTheme();

	public long getViews();

	public long getSubscribers();

	public long getDollars();

	public Integer getWork();

	public Integer getSalaire();

	public Integer getLvl_animations_films();

	public Integer getLvl_divertissement();

	public Integer getLvl_gaming();

	public Integer getLvl_humour();

	public Integer getLvl_makeup_mode();

	public Integer getLvl_musique();

	public Integer getLvl_sciences();

	public Integer getLvl_sport();

	public Integer getLvl_cuisine();

	public Integer getLvl_montage();

	public Integer getLvl_ecriture();

	public Integer getLvl_post_prod();

	public long getExp_animations_films();

	public long getExp_divertissement();

	public long getExp_gaming();

	public long getExp_humour();

	public long getExp_makeup_mode();

	public long getExp_musique();

	public long getExp_sciences();

	public long getExp_sport();

	public long getExp_cuisine();

	public long getExp_montage();

	public long getExp_ecriture();

	public long getExp_post_prod();

}
