const fs = require("fs");
// const input = fs.readFileSync('/dev/stdin').toString().trim().split(/\r\n|\r|\n/);
const input = fs
  .readFileSync("input.txt")
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);
let [M, N] = input[0].split(" ").map((val) => Number(val));

let primeArr = new Array(N + 1).fill(false); //소수이면 false
primeArr[1] = true;
for (let i = 2; i <= N; i++) {
  for (let idx = 2; idx * i <= N; idx++) {
    primeArr[idx * i] = true;
  }
}
let ans = [];
for (let i = M; i <= N; i++) {
  if (!primeArr[i]) ans.push(i);
}
console.log(ans.join("\n"));
