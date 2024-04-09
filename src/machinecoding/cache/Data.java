package machinecoding.cache;

public class Data {
	int value;
	int count;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	Data(int value, int count) {
		this.value = value;
		this.count = count;
	}
}
