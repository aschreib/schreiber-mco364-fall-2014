package schreiber.paint.message;

public class ClearMessage implements PaintMessage {

	public ClearMessage() {

	}

	@Override
	public String toString() {
		return "\n";
	}

}
