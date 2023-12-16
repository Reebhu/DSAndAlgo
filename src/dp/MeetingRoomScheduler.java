package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MeetingRoomScheduler {

	/*You are given an integer n. There are n rooms numbered from 0 to n - 1.

	You are given meeting schedules in the following form [start, end], means that a meeting will be held during the time interval [start, end], for multiple meetins in a day. All the values of
	start are unique.

	Meetings are allocated to rooms in the following manner:

	Each meeting will take place in the unused room with the lowest number.
	If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should have the same duration as the original meeting.
	When a room becomes unused, meetings that have an earlier original start time should be given the room.

	Find which meeting room was most used. If there are are multiple, then the room with lower index should be reported.


	n=2

	input:   [13,14],  [14,15], [12,14],  */
	public static void main(String[] args) {
		Meeting[] input = {new Meeting(13, 14), new Meeting(14, 15), new Meeting(15, 16)};
		int n = 2;
		//To check how many meeting have completed in a particular index
		int[] count = new int[n];

		sortInput(input);
//		[12,16], [13,17],  [14,15]

		Map<Integer, Integer> endRoomMap = new TreeMap<>();

		int occupied = 0;
		int prevEndTime = Integer.MIN_VALUE;

		for (int i = 0; i < input.length; i++) {
			int startTime = input[i].startTime;
			int endTime = input[i].endTime;

			if (occupied < n) {
				if (prevEndTime < startTime)
					occupied = occupied - 1 <= 0 ? 0 : occupied - 1;
				endRoomMap.putIfAbsent(endTime, occupied);
				count[occupied]++;
				occupied++;
			}
			else {
				boolean meetingfound = false;
				for (Map.Entry<Integer, Integer> entry : endRoomMap.entrySet()) {
					if (entry.getKey() <= startTime) {
						meetingfound = true;
						count[entry.getValue()] = count[entry.getValue()] + 1;
						endRoomMap.putIfAbsent(endTime, entry.getValue());
						endRoomMap.remove(entry.getKey());
					}
				}
				if (!meetingfound) {
					Map.Entry<Integer, Integer> firstEndTime = endRoomMap.entrySet().iterator().hasNext() ? endRoomMap.entrySet().iterator().next() : null;
					if (firstEndTime != null) {
						count[firstEndTime.getValue()] = count[firstEndTime.getValue()] + 1;
						endRoomMap.put(endTime, firstEndTime.getValue());
						endRoomMap.remove(firstEndTime.getKey());
					}
				}
			}
		}
		int max = Integer.MIN_VALUE;
		int roomNo = 0;
		for (int i = 0; i < count.length; i++) {
			if (max < count[i]) {
				max = count[i];
				roomNo = i;
			}
		}

		System.out.println(roomNo);
	}

	static void sortInput(Meeting[] arr) {
		Arrays.sort(arr, new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1, Meeting o2) {
				return o1.startTime - o2.startTime;
			}
		});
	}

	static class Meeting {
		int startTime;
		int endTime;

		Meeting(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}
}
