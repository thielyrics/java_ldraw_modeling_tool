package glbrick;


public class OptionalLineSpec implements BrickSpec {

	public OptionalLineSpec(String[] lineParts) {
		super();
		// TODO Auto-generated constructor stub
	}

	public OptionalLineSpec(String[] lineParts, ColorBase colors) { 
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isCommment() {
		// TODO Auto-generated method stub
		return false;
	}


	/*public DrawnObject toDrawnObject(ArrayList<double[]> vs, double[] loc,
			ObjectType type, float[] color) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public DrawnObject toDrawnObject() {
		return new DrawnObject();
	}
	

}
