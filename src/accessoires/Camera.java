package accessoires;

public class Camera extends Accessoire{
	
	private Performance perf;
	
	public Camera(String name, int price, Performance perf, String path, long ID){
		this.name=name;
		this.price=price;
		this.perf=perf;
		this.path=path;
		this.ID=ID;
	}

}