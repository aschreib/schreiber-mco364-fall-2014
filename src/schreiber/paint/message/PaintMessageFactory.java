package schreiber.paint.message;

public class PaintMessageFactory {

	PaintMessage paintMessage;

	public PaintMessage getMessage(String s) {
		String[] info = s.split(" ");
		switch (info[0]) {
		case "LineMessage":
			// paintMessage = new LineMessage(info[1], info[2], info[3],
			// info[4], info[5], info[6]);
			break;
		case "ShapeMessage":
			break;
		case "ClearMessage":
			break;
		case "BucketFillMessage":
			break;
		}

		return paintMessage;
	}

}
