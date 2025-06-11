const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let X = null;

const solution = (x) => {
  // 1,2,4,8,16,32,64 중 하나일것이고
  // 1이 1개씩 있으면 막대기임 이게 너무 신기하네..
  let str = x.toString(2);

  console.log(str.split("1").length - 1);
  // console.log(result);
};
rl.on("line", (line) => {
  X = +line;
  solution(X);

  rl.close();
}).on("close", () => {
  process.exit();
});
