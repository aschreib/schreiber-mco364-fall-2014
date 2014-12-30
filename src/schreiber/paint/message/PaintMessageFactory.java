package schreiber.paint.message;

public class PaintMessageFactory {

	PaintMessage paintMessage;

	public PaintMessage getMessage(String s) {
		String[] info = s.split(" ");
		switch (info[0]) {
		case "LINE":
			int x1 = Integer.valueOf(info[1]);
			int y1 = Integer.valueOf(info[2]);
			int x2 = Integer.valueOf(info[3]);
			int y2 = Integer.valueOf(info[4]);
			int lineColor = Integer.valueOf(info[5]);
			int lineStrokeWidth = Integer.valueOf(info[6]);
			paintMessage = new LineMessage(x1, y1, x2, y2, lineColor,
					lineStrokeWidth);
			break;
		case "SHAPE":
			ShapeType shapeType = ShapeType.valueOf(info[1]);
			int shapeX = Integer.valueOf(info[2]);
			int shapeY = Integer.valueOf(info[3]);
			int width = Integer.valueOf(info[4]);
			int height = Integer.valueOf(info[5]);
			int shapeColor = Integer.valueOf(info[6]);
			int shapeStrokeWidth = Integer.valueOf(info[7]);
			boolean fill = Boolean.valueOf(info[8]);
			paintMessage = new ShapeMessage(shapeType, shapeX, shapeY, width,
					height, shapeColor, shapeStrokeWidth, fill);
			break;
		case "CLEAR":
			paintMessage = new ClearMessage();
			break;
		case "BUCKET_FILL":
			int bucketX = Integer.valueOf(info[1]);
			int bucketY = Integer.valueOf(info[2]);
			int bucketColor = Integer.valueOf(info[3]);
			paintMessage = new BucketFillMessage(bucketX, bucketY, bucketColor);
			break;
		}

		return paintMessage;
	}
}
