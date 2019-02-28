package problem04;

import java.util.*;
import java.io.*;

public class Main {

	public static int correct_count = 0, discorrect_count = 0;

	public static Map<String, Integer> examInit() {
		// 문제 구성과 답을 위한 exam_Set
		Map<String, Integer> exam_set = new HashMap<String, Integer>();
		Random r = new Random();

		int dan_right = 0;

		for (int dan = 1; dan < 10; dan++) {
			for (int j = 0; j < 2; j++) {
				dan_right = Math.abs(r.nextInt() % 9) + 1;
				String key = dan + "X" + dan_right;

				// 중복키 방지
				while (!exam_set.containsKey(key)) {
					exam_set.put(dan + "X" + dan_right, dan * dan_right);
				}
			}
		}

		return exam_set;
	}

	public static void answerCheck(int user_answer, int answer) {
		if (user_answer == answer) {
			System.out.println("정답");
			correct_count++;
		} else {
			System.out.println("오답");
			correct_count++;
		}
	}

	public static void main(String[] args) throws IOException {
		Map<String, Integer> exam_set = examInit();
		Random r = new Random();
		int exam_count = 1;

		// 시간 측정 변수들
		long start_time, end_time;
		double result_time;

		System.out.println("시험시작");
		System.out.println(exam_set.size());
		// 시험시작되면 시작타이머 시작
		start_time = System.currentTimeMillis();
		while (!exam_set.isEmpty()) {

			List<String> keysAsArray = new ArrayList<String>(exam_set.keySet());
			Scanner rd = new Scanner(System.in);

			// 랜덤으로 얻어낸 키와 그에 대항되는 값
			String set_random_key = keysAsArray.get(r.nextInt(keysAsArray.size()));
			int get_random_value = exam_set.get(set_random_key);

			System.out.println(exam_count + "번 문제 : " + set_random_key);
			int user_answer = rd.nextInt();
			answerCheck(user_answer, get_random_value);

			exam_set.remove(set_random_key);

			exam_count++;
		}
		// 시험 끝나면 타이머도 같이 종료
		end_time = System.currentTimeMillis();
		result_time = (end_time - start_time) / 1000.0;

		System.out.println(correct_count);
		System.out.println(discorrect_count);
		System.out.println(result_time);
		
	}
}