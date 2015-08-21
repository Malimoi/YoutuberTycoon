package accessoires;

public class Ordinateur extends Accessoire{
	
	public Ordinateur(String name, int price, Performance perf, String path, long ID, boolean buy){
		
		this.name=name;
		this.price=price;
		this.perf=perf;
		this.path=path;
		this.ID=ID;
		this.buy=buy;
		
	}

}
