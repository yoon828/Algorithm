const fs = require("fs");
// const input = fs.readFileSync('/dev/stdin').toString().trim().split(/\r\n|\r|\n/);
const input = fs
  .readFileSync("input.txt")
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let N = parseInt(input[0]);
let cnt = 0;
let num = 1;
while (N !== cnt) {
  if (num.toString().includes("666")) cnt++;
  num++;
}
console.log(num-1);