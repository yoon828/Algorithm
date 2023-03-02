const fs = require("fs");
// const input = fs.readFileSync('/dev/stdin').toString().trim().split(/\r\n|\r|\n/);
const input = fs
  .readFileSync("input.txt")
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);
let T = input.shift();
for (let tc = 1; tc <= T; tc++) {
  let [N, M] = input.shift().split(" ");
  let cnt = 0;
  let arr = input
    .shift()
    .split(" ")
    .map((val) => parseInt(val));
  let sorted = arr.slice(0).sort((a, b) => b - a);
  let idx = 0;
  while (sorted.length !== 0) {
    if (arr[idx % N] === sorted[0]) {
      sorted.shift();
      cnt++;
      if (idx % N === Number(M)) break;
    }
    idx++;
  }
  console.log(cnt);
}
