const fs = require("fs");
// const input = fs.readFileSync('/dev/stdin').toString().trim().split(/\r\n|\r|\n/);
const input = fs
  .readFileSync("input.txt")
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

function solve(num) {
  let arr = num.toString().split("");
  let N = arr.length;
  for (let i = 0; i < N / 2; i++) {
    if (arr[i] !== arr[N - 1 - i]) return "no";
  }
  return "yes";
}

input.forEach((val) => {
  val = parseInt(val);
  if (val !== 0) {
    console.log(solve(val));
  }
});
