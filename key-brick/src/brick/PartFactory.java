package brick;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PartFactory {
	private TreeMap<String,PartSpec> parts;
	private ArrayList<String> paths;
	private ColorBase colors;
	private boolean printFailures;
	
	public PartFactory(String ldrawPath) throws FileNotFoundException {
		paths = new ArrayList<String>();
		parts = new TreeMap<String,PartSpec>();
		colors = new ColorBase(ldrawPath);
		printFailures = false;
		
		String partsPath = ldrawPath + File.separator + "PARTS";
		String pPath = ldrawPath + File.separator + "P";

		addPath(partsPath);
		addPath(pPath);
		addPath(partsPath + File.separator + "S");
		addPath(pPath + File.separator + "48");
	}
	
	public void activateFailureErrors() {
		printFailures = true;
	}
	
	public Collection<PartSpec> getAllParts() {return parts.values();}
	
	public void addPath(String path) {
		paths.add(path);
	}

	public PartSpec getPart(String partName) throws PartNotFoundException {
		if (parts.containsKey(partName)) {
			return parts.get(partName);
		} else {
			for (String path: paths) {
				try {
					PartSpec result = tryFile(path, partName);
					parts.put(partName, result);
					return result;
				} catch (FileNotFoundException e) {
					if (printFailures) {
						System.out.println(e.getMessage());
					}
				}
			}
			throw new PartNotFoundException(partName);
		}
	}

	private PartSpec tryFile(String path, String partName) throws FileNotFoundException, PartNotFoundException {
		String filename = path + File.separator + Util.fixPath(partName);
		Scanner s = new Scanner(new File(filename));
		PartSpec result = new PartSpec(partName, colors);
		while (s.hasNextLine()) {
			String[] lineParts = s.nextLine().split("\\s+");
			if (lineParts.length > 0 && lineParts[0].length() > 0) {
				int code = Integer.parseInt(lineParts[0]);
				if (code == 0) {
					result.addLine(new CommentSpec(lineParts));
				} else if (code == 1) {
					result.addLine(new SubpartSpec(lineParts, this));
				} else if (code == 2) {
					result.addLine(new LineSpec(lineParts, colors));
				} else if (code == 3) {
					result.addLine(new TriangleSpec(lineParts, colors));
				} else if (code == 4) {
					result.addLine(new QuadSpec(lineParts, colors));
				} else if (code == 5) {
					result.addLine(new OptionalLineSpec(lineParts, colors));
				}
			}
		}
		s.close();
		return result;
	}
}
