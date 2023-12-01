package util;

public class Pair<T, T1> {

	private final T1 right;

	private final T left;

	private Pair(T left, T1 right) {
		this.left = left;
		this.right = right;
	}

	public static <T, T1> Pair<T, T1> of(T left, T1 right) {
		return new Pair<T, T1>(left, right);
	}

	public T getLeft() {
		return left;
	}

	public T1 getRight() {
		return right;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Pair{");
		sb.append("right=").append(right.toString());
		sb.append(", left=").append(left.toString());
		sb.append('}');
		return sb.toString();
	}
}
