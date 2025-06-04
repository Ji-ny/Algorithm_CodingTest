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

const solution = (N, M, I, data) => {
  let queue = [I]; // 시작 지점 저장
  // 도연의 위치는 탐색 안하는 곳으로 설정
  let peopleCount = 0; // 사람 수
  let headIdx = 0; // 배열을 큐로 쓰되, headIdx를 관리해서 O(1)로 꺼내도록 한다.

  data[I[0]][I[1]] = "X";

  // 상, 하, 좌, 우
  const dRow = [-1, 1, 0, 0];
  const dCol = [0, 0, -1, 1];

  while (headIdx < queue.length) {
    // shift() 대신 headIdx를 써서 O(1)로 꺼낸다.
    let [row, col] = queue[headIdx++]; // 현 위치 저장
    // let [row, col] = queue.shift(); // 현 위치 저장

    // 상, 하, 좌, 우 앞으로 가게 될 미래 위치 구하기
    for (let i = 0; i < 4; i++) {
      let newRow = row + dRow[i];
      let newCol = col + dCol[i];

      // 새로운 위치가 범위를 벗어나거나 벽이라면 패스
      if (
        newRow < 0 ||
        newRow >= N ||
        newCol < 0 ||
        newCol >= M ||
        data[newRow][newCol] === "X"
      ) {
        continue;
      }

      // 새로운 위치에 사람이 있다면 (P) count 1 증가
      if (data[newRow][newCol] === "P") {
        peopleCount++;
      }

      // 새로운 위치가 빈 공간(O) 이거나 사람이 있다면 현재 위치 저장!
      queue.push([newRow, newCol]); // 현재 위치 추가
      data[newRow][newCol] = "X"; // 그냥 벽으로 업데이트
    }

    // console.log(row, col);
    // data.forEach((item) => {
    //   console.log(item);
    // });
  }

  if (peopleCount > 0) {
    console.log(peopleCount);
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
