import java.io.*;
import java.util.*;

public class Main {

	static int N; // Map의 크기
	static int M; // 참가자의 수
	static int K; // 플레이 시간
	static int[][] map;
	static List<int[]> participants = new ArrayList<>();
	static int[] exit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int totalMove = 0; // 모든 참가자들의 이동 거리 합

	static class Square {
		int col, row; // 정사각형의 상좌 좌표
		int length;

		public Square(int row, int col, int length) {
			this.col = col;
			this.row = row;
			this.length = length;
		}

		@Override
		public String toString() {
			return "Square [row=" + row + ", col=" + col + ", length=" + length + "]";
		}

	}

	public static void main(String[] args) throws Exception {

		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			int[] participant = new int[2];
			st = new StringTokenizer(br.readLine());
			participant[0] = Integer.parseInt(st.nextToken()) - 1;
			participant[1] = Integer.parseInt(st.nextToken()) - 1;
			participants.add(participant);
		}
		st = new StringTokenizer(br.readLine());
		exit = new int[2];
		exit[0] = Integer.parseInt(st.nextToken()) - 1;
		exit[1] = Integer.parseInt(st.nextToken()) - 1;

		/* K초 동안 게임 진행 */
		while (K-- > 0) {
			// 이동
			moveAllParticipants();
			// 모든 사람이 탈출했을 때
			if (participants.isEmpty()) {
				break;
			}
			// 회전
			rotateSquare();

		}

		/* 출력 */
		System.out.println(totalMove);
		System.out.println(exit[0]+1 + " " + (exit[1]+1));
	}

	/* 모든 참가자 이동시키기 */
	private static void moveAllParticipants() {
		for (int i = participants.size() - 1; i >= 0; i--) {
			moveParticipant(i);
		}
	}

	/* 참가자 이동 */
	private static void moveParticipant(int i) {
		int[] participant = participants.get(i);
		int minDistance = calculateDistance(participant[0], participant[1]);
		int minDirection = -1;
		for (int j = 0; j < 4; j++) {
			int nx = participant[0] + dx[j];
			int ny = participant[1] + dy[j];
			// 맵 밖으로 나갔을 때
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				continue;
			}
			// 벽이 있을 때
			if (map[nx][ny] != 0) {
				continue;
			}
			int curDistance = calculateDistance(nx, ny);
			// 참가자가 출구를 찾았을때
			if (curDistance == 0) {
				participants.remove(i);
				totalMove += 1;
				break;
			}
			if (curDistance < minDistance) {
				minDistance = curDistance;
				minDirection = j;
			}
		}
		if (minDirection > -1) {
			participant[0] = participant[0] + dx[minDirection];
			participant[1] = participant[1] + dy[minDirection];
			totalMove += 1;
		}
	}

	/* 참가자 - 출구의 거리 계산하기 */
	private static int calculateDistance(int x1, int y1) {
		int x2 = exit[0];
		int y2 = exit[1];
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	/* 정사각형 회전하기 */
	private static void rotateSquare() {
		// 가장 작은 정사각형 찾기
		Square square = searchSquare();
		// 정사각형 90도로 회전하기
		rotate90Degrees(square);
		// 참가자, 출구 회전하기
		rotateParticipantsAndExit(square);
	}

	/* 가장 작은 정사각형 찾기 */
	private static Square searchSquare() {
		// 정사각형 위치 정하기
		int minLength = N * N + 1;
		int minRow = N;
		int minCol = N;
		for (int i = 0; i < participants.size(); i++) {
			int partX = participants.get(i)[0];
			int partY = participants.get(i)[1];
			
			// 직사각형 구하기
			int squareLength = 0; // 변의 길이
			if (Math.abs(partX - exit[0]) < Math.abs(partY - exit[1])) {
				squareLength = Math.abs(partY - exit[1]) + 1;
			} else {
				squareLength = Math.abs(partX - exit[0]) + 1;
			}
			
			int firstRow = partX < exit[0] ? partX : exit[0]; // 좌상 row
			int firstCol = partY < exit[1] ? partY : exit[1]; // 좌상 col
			int secondRow = partX > exit[0] ? partX : exit[0]; // 우하 row
			int secondCol = partY > exit[1] ? partY : exit[1]; // 우하 col
			
			// 정사각형 구하기
			int requiredRow = secondRow - firstRow;
			int requiredCol = secondCol - firstCol;
			
			// 상하 늘리기
			if (requiredRow < requiredCol) {
				int requiredLength = requiredCol - requiredRow;
				while (requiredLength-- > 0) {
					if (firstRow <= 0) {
						break;
					}
					firstRow--;
				}
				while (requiredLength-- > 0) {
					secondRow++;
				}
			}
			
			// 좌우 늘리기
			else if (requiredRow > requiredCol){
				int requiredLength = requiredRow - requiredCol;
				while (requiredLength-- > 0) {
					if (firstCol <= 0) {
						break;
					}
					firstCol--;
				}
				while (requiredLength-- > 0) {
					secondCol++;
				}
			}
			
			// 정사각형 업데이트
			if (minLength > squareLength) {
				minLength = squareLength;
				minRow = firstRow;
				minCol = firstCol;
			}
			else if (minLength == squareLength && minRow > firstRow) {
				minLength = squareLength;
				minRow = firstRow;
				minCol = firstCol;
			}
			else if (minLength == squareLength && minRow == firstRow && minCol > firstCol) {
				minLength = squareLength;
				minRow = firstRow;
				minCol = firstCol;
			}	
		}
		
		return new Square(minRow, minCol, minLength);
	}

	/* 정사각형 90도로 회전하기 */
	private static void rotate90Degrees(Square square) {
		
		// 원래 미로 map 복사하기
		int[][] clonedMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			clonedMap[i] = map[i].clone();
		}

		// 미로 회전하기
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square.length; j++) {
				// 내구도 1씩 줄이기
				if (clonedMap[square.row + i][square.col + j] != 0) {
					clonedMap[square.row + i][square.col + j]--;
				}
				map[j + square.row][square.col + square.length - 1 - i] = clonedMap[i + square.row][j + square.col];
			}
		}
	}

	/* 참가자, 출구 돌리기 */
	private static void rotateParticipantsAndExit(Square square) {
		
		// 참가자 돌리기
		for (int i = 0; i < participants.size(); i++) {
			int[] participant = participants.get(i);
			if (participant[0] < square.row || participant[0] >= square.row + square.length) {
				continue;
			}
			if (participant[1] < square.col || participant[1] >= square.col + square.length) {
				continue;
			}
			int x = participant[0] - square.row;
			int y = participant[1] - square.col;
			int[] rotatedLocation = { y + square.row, square.col + square.length - 1 - x };
			participants.set(i, rotatedLocation);
		}

		// 출구 돌리기
		int exitX = exit[0] - square.row;
		int exitY = exit[1] - square.col;
		exit = new int[] { exitY + square.row, square.col + square.length - 1 - exitX };
	}

}
