package modele;


public abstract class BDEntity {
	private final int id;
	
	public BDEntity(int id) {
		super();
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public abstract void init();
	
	public abstract String toString();
}
