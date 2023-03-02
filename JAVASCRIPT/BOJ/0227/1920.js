const fs = require("fs");
// const input = fs.readFileSync('/dev/stdin').toString().trim().split(/\r\n|\r|\n/);
const input = fs
  .readFileSync("input.txt")
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);
let arr = input[1].split(" ").map((val) => Number(val));
arr.sort((a, b) => a - b);
let tmp = input[3].split(" ").map((val) => Number(val));

let ans = tmp.map((ele) => {
  let [low, high] = [0, arr.length - 1];
  while (low <= high) {
    let mid = parseInt((low + high) / 2);
    if (arr[mid] === ele) return 1;
    else if (arr[mid] < ele) low = mid + 1;
    else high = mid - 1;
  }
  return 0;
});
console.log(ans.join("\n"));
