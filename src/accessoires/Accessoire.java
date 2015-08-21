package accessoires;

public abstract class Accessoire {
	
	protected String name;
	protected int price;
	protected Performance perf;
	protected String path;
	protected long ID;
	protected boolean buy;
	
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public Performance getPerf() {
		return perf;
	}
	public String getPath() {
		return path;
	}
	public long getID() {
		return ID;
	}
	public boolean isBuy() {
		return buy;
	}

}
