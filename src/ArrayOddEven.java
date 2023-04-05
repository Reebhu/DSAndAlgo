import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class ArrayOddEven {
	public static void main(String[] args) {
		int[] input = {2, 2, 2, 0, 2, 1};
		int[] arr = arrange(input.length, input);
		System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
	}

	public static int[] arrange(int len, int[] arr) {
		Queue<Integer> oddList = new PriorityQueue<>();
		Queue<Integer> evenList = new PriorityQueue<>();
		Arrays.sort(arr);
		for (Integer i : arr) {
			if (i % 2 != 0)
				oddList.add(i);
			else
				evenList.add(i);
		}
		int[] output = new int[len];
		boolean even = arr[0] % 2 == 0;
		for (int i = 0; i < len; i++) {
			if (even && evenList.peek() != null) {
				output[i] = evenList.poll();
				even = false;
			}
			else if (!even && oddList.peek() != null) {
				output[i] = oddList.poll();
				even = true;
			}
			else if (evenList.isEmpty() && !oddList.isEmpty()) {
				output[i] = oddList.poll();
				even = false;
			}
			else if (oddList.isEmpty() && !evenList.isEmpty()) {
				output[i] = evenList.poll();
				even = true;
			}
		}
		return output;
	}
}
