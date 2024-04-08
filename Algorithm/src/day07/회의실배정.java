package study;

import java.util.*;

public class 회의실배정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("회의 수: ");
		int n = sc.nextInt();

		System.out.println("회의 시작 시간 종료 시간 입력: ");
		ArrayList<Time> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			arr.add(new Time(start, end));
		}

		ArrayList<Time> meetings = solution(arr);

		System.out.println("최대 가능한 회의 수: " + meetings.size());
		System.out.println("선택된 회의 시간: ");
		for (int i = 0; i < meetings.size(); i++) {
			Time meeting = meetings.get(i);
			System.out.println("Time [start=" + meeting.start + ", end= " + meeting.end + "]");
		}
	}

	public static ArrayList<Time> solution(ArrayList<Time> arr) {
		ArrayList<Time> meetings = new ArrayList<>();
		int prevEndTime = 0;

		// 이 부분이 잘 안 돼서 검색 찬스 사용
		Collections.sort(arr, new Comparator<Time>() {
			@Override
			public int compare(Time t1, Time t2) {
				if (t1.end == t2.end) { // 끝나는 시간 같다면 시작 시간 오름차순
					return Integer.compare(t1.start, t2.start);
				}
				return Integer.compare(t1.end, t2.end); // 오름차순 정렬
			}
		});

		for (Time meeting : arr) {
			if (meeting.start >= prevEndTime) { // 회의 시작과 이전 종료 시간 같거나 크다
				meetings.add(meeting);
				prevEndTime = meeting.end;
			}
		}

		return meetings;
	}
}

class Time {
	public int start, end;

	Time(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
