const fs = require("fs");
// const input = fs.readFileSync('/dev/stdin').toString().trim().split(/\r\n|\r|\n/);
const input = fs
  .readFileSync("input.txt")
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

//N은 홀수
let ans = [];
let N = Number(input.shift());
let arr = input.map((v) => Number(v));
let tmp = [...arr].sort((a, b) => a - b);

//평균
let sum = tmp.reduce((pre, cur) => (pre += cur), 0);
ans.push(Math.round(sum / tmp.length));
//중앙값
ans.push(tmp[Math.floor(N / 2)]);
//최빈값
let cnt = new Array(4000 * 2 + 1).fill(0);
tmp.forEach((val) => cnt[val + 4000]++);
let max = Math.max(...cnt);
let maxCnt = [];
cnt.forEach((val, idx) => {
  if (max === val) {
    maxCnt.push(idx - 4000);
  }
});
ans.push(maxCnt.length > 1 ? maxCnt[1] : maxCnt[0]);

//범위(최댓값, 최솟값 차이)
ans.push(tmp[tmp.length - 1] - tmp[0]);

console.log(ans.join("\n"));
