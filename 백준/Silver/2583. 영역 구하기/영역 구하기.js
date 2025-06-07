const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let M = null; // 행
let N = null; // 열
let K = null; // 직사각형 개수
let leftDown = [0, 0]; // 왼쪽 아래 좌표
let rightTop = [0, 0]; // 왼쪽 위 좌표
let countK = 0;
let data = null;
let count = 0; // 거리마다 카운트
let area = 0; // 분리되는 영역 개수
let result = [];

// x,y를 순회하기
const dfs = (row, col) => {
  // 만약 경로를 벗어났다면 패스

  if (row < 0 || row >= M || col < 0 || col >= N) {
    return false;
  }

  if (data[row][col] === 1) {
    return false;
  }
  // 만약 벽이라면 패스

  // 방문 처리
  data[row][col] = 1;

  // 방문 가능한 곳일 때 count 증가
  count++;

  // console.log(count, data);

  // 상,하,좌,우 순회
  const dRow = [-1, 1, 0, 0];
  const dCol = [0, 0, -1, 1];

  // 상,하,좌,우 dfs 진행하기
  for (let i = 0; i < 4; i++) {
    dfs(row + dRow[i], col + dCol[i]);
  }

  return true;
};

const solution = (data) => {
  // console.log(data);
  // data.forEach((item) => {
  //   console.log(item);
  // });

  // dfs를 이용하여 0~ N 까지 반복한다.
  for (let i = 0; i < M; i++) {
    for (let j = 0; j < N; j++) {
      // 만약 새로 간 지역이라면
      if (data[i][j] === 0) {
        count = 0; // count 0으로 다시 초기화
        area++; // 영역 추가
        dfs(i, j);
        result.push(count); // count push하기
      }
    }
  }
  console.log(area);
  console.log(result.sort((a, b) => a - b).join(" "));
  return;
};

rl.on("line", (line) => {
  if (!M) {
    [M, N, K] = line.split(" ").map((item) => +item);
    data = Array(M)
      .fill()
      .map(() => Array(N).fill(0));
    // * M행 N열 0로 이루어진 데이터를 만들어준다.
  } else {
    countK++; // data를 입력받으면 count를 증가시킴
    let [leftDownX, leftDownY, rightTopX, rightTopY] = line // 영역좌표를 저장
      .split(" ")
      .map(Number);

    // 영역만큼 1을 채운다.
    // 왼쪽X < 오른쪽 X까지
    // 왼쪽Y 오른쪽 Y까지
    for (let y = leftDownY; y < rightTopY; y++) {
      for (let x = leftDownX; x < rightTopX; x++) {
        data[y][x] = 1; // 네모 영역은 1로 업데이트
      }
    }
  }

  if (countK === K) {
    solution(data);
    rl.close();
  }
}).on("close", () => {
  process.exit();
});

// 입력
// 1 3 1
// 1 0 2 1

// 정답
// 2
// 1 1
