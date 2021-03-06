package glbrick;




public class SubpartSpec implements BrickSpec {



	String[] lineParts;
	//private int c;
	private double[] loc = {0,0,0};
	private double[][] trans = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
	//private ArrayList<double[]> vertices;
	@SuppressWarnings("unused")
	private ColorBase colors;
	float lineColorValue;
	String partName = "";
	private PartSpec part;



	public SubpartSpec(String[] lineParts) {
		super();
		// TODO Auto-generated constructor stub
	}
	public String toString(){
		return partName;//glbrickUtilities.stringer(vertices); // does what you think it does
	}

	public SubpartSpec(String[] lineParts, PartFactory partFactory) throws PartNotFoundException 
	{
		//System.out.println("subpartspec call");
		this.lineParts = lineParts;

		lineColorValue = Float.parseFloat(lineParts[1]);

		loc[0] = Double.parseDouble(lineParts[2]);
		loc[1] = Double.parseDouble(lineParts[3]);
		loc[2] = Double.parseDouble(lineParts[4]);

		for (int i = 5; i <= 13; i++)
		{
			trans[(i-5) / 3][(i-5) % 3] = Double.parseDouble(lineParts[i]);
		}


		partName = lineParts[14];

		this.part = partFactory.getPart(this.partName);

		//1 colour x y z a b c d e f g h i part.dat

	}


	@Override
	public boolean isCommment() {
		return false;
	}

	public DrawnObject toDrawnObject() 
	{
//		System.out.println("subpartspec todrwanobject called");
		//something about lineColorValue;
		//double[] temp = new double[]{1,1,1}; 
		DrawnObject tempmodel = part.toDrawnObject();
		tempmodel.setLocation(loc);
		tempmodel.setTransformation(trans);
		tempmodel.SetPartName(partName);
//		System.out.println(partName + "SPSln70");
		return tempmodel;

	}
}