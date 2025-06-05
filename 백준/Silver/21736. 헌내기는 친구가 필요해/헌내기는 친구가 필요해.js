const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let N = null;
let M = null;
let I = null; // 도연이 시작 위치 [row, col]
let nCount = 0;
let data = [];

let personCount = 0;

const dfs = (row, col) => {
  // console.log(row, col);
  // data.forEach((item) => {
  //   console.log(item);
  // });
  // 주어진 범위를 벗어나면 즉시 종료하자.
  if (row < 0 || row >= N || col < 0 || col >= M) {
    // *벽이라도 패스
    return;
  }

  if (data[row][col] === "X") {
    return;
  }

  // * 사람이 있는 곳이라면 "P" count +=1
  if (data[row][col] === "P") {
    personCount++; // 사람수 1 증가
  }
  // * 왔던 위치 방문처리
  data[row][col] = "X";

  // console.log(personCount);
  // * 내 위치 기준으로 상,하,좌,우를 dfs로 찾는다.
  const dRow = [-1, 1, 0, 0];
  const dCol = [0, 0, -1, 1];

  for (let i = 0; i < 4; i++) {
    dfs(row + dRow[i], col + dCol[i]);
  }

  return;
};

const solution = (N, M, I, data) => {
  // 도연의 위치는 탐색 안하는 곳으로 설정

  // * dfs 수행
  // 시작 위치부터 한다.

  dfs(I[0], I[1]);

  if (personCount > 0) {
    console.log(personCount);
  } else {
    console.log("TT");
  }
};

rl.on("line", (line) => {
  if (!N) {
    [N, M] = line.split(" ").map((item) => +item); // 캠퍼스 크기 입력 (nxm)
  } else {
    data.push(
      line.split("").map((item, index) => {
        if (item === "I") {
          I = [nCount, index]; // 도연이 위치 저장
        }
        return item;
      })
    );
    nCount++; // 카운트 증가
  }

  if (nCount === N) {
    // n개 데이터 입력했다면
    solution(N, M, I, data);
    rl.close();
  }
}).on("close", () => {
  process.exit();
});
