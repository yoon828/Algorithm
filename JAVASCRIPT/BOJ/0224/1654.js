const fs = require("fs");
// const input = fs.readFileSync('/dev/stdin').toString().trim().split(/\r\n|\r|\n/);
const input = fs
  .readFileSync("input.txt")
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);
let [K, N] = input
  .shift()
  .split(" ")
  .map((v) => parseInt(v));
let lens = [...input];
let [low, high] = [0, Math.max(...lens) + 1];
let mid = 0;
while (low + 1 < high) {
  let cnt = 0;
  mid = parseInt((low + high) / 2);
  if (low + 1 === high) mid = high;
  lens.forEach((len) => (cnt += parseInt(len / mid)));
  console.log(cnt, low, high, mid);
  if (cnt >= N) {
    if (low === mid) low = high;
    else low = mid;
  } else {
    high = mid;
  }
}
console.log(low);
