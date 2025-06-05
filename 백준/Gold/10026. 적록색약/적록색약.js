const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let N = null;
let M = null;
let nCount = 0;
let data = [];
let yesVisited = []; // 적록색약 O
let noVisited = []; // 적록색약 X

let yes = 0; // 적록색약 O
let no = 0; // 적록색약 x

// !적록X dfs
const dfsNo = (row, col, color) => {
  // 주어진 범위를 벗어나면 즉시 종료하자.
  if (row < 0 || row >= N || col < 0 || col >= N) {
    // *벽이라도 패스
    return false;
  }
  // * 이미 온 곳이면 패스
  if (noVisited[row][col] === "X") {
    return false;
  }

  // 색상과 같지않다먄
  if (color !== noVisited[row][col]) {
    return false;
  }

  // console.log(row, col, color);
  // noVisited.forEach((item) => {
  //   console.log(item);
  // });
  // 같다면 방문 표시
  noVisited[row][col] = "X";

  // console.log(personCount);
  // * 내 위치 기준으로 상,하,좌,우를 dfs로 찾는다.
  const dRow = [-1, 1, 0, 0];
  const dCol = [0, 0, -1, 1];

  for (let i = 0; i < 4; i++) {
    dfsNo(row + dRow[i], col + dCol[i], color);
  }

  return true; // 방문했으니 true
};

// !적록O dfs
const dfsYes = (row, col, color) => {
  // 주어진 범위를 벗어나면 즉시 종료하자.
  if (row < 0 || row >= N || col < 0 || col >= N) {
    // *벽이라도 패스
    return false;
  }
  // * 이미 온 곳이면 패스
  if (yesVisited[row][col] === "X") {
    return false;
  }

  if (
    color === "B" ? yesVisited[row][col] !== "B" : yesVisited[row][col] === "B"
  ) {
    // B 그룹인데 대상이 B가 아니거나, R/G 그룹인데 대상이 B인 경우
    return false;
  }

  // console.log(row, col, color);
  // yesVisited.forEach((item) => {
  //   console.log(item);
  // });
  // 같다면 방문 표시
  yesVisited[row][col] = "X";

  // console.log(personCount);
  // * 내 위치 기준으로 상,하,좌,우를 dfs로 찾는다.
  const dRow = [-1, 1, 0, 0];
  const dCol = [0, 0, -1, 1];

  for (let i = 0; i < 4; i++) {
    dfsYes(row + dRow[i], col + dCol[i], color);
  }

  return true; // 방문했으니 true
};

const solution = (N, data) => {
  // console.log(N, data);

  //* red, green 방문 데이터 복사
  yesVisited = data.map((row) => row.slice());
  noVisited = data.map((row) => row.slice());
  standardColor = data[0][0]; // 기본 기준 컬러 : 0번째

  // * dfs 수행  0번부터 n번까지 dfs 수행
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (dfsNo(i, j, data[i][j])) {
        no++; // 적록 X
      }

      if (dfsYes(i, j, data[i][j])) {
        yes++; // 적록 O
      }
    }
  }

  console.log(no, yes);
};

rl.on("line", (line) => {
  if (!N) {
    N = +line; // 배열의 크기
  } else {
    data.push(line.split(""));
    nCount++; // 카운트 증가
  }

  if (nCount === N) {
    // n개 데이터 입력했다면
    solution(N, data);
    rl.close();
  }
}).on("close", () => {
  process.exit();
});
