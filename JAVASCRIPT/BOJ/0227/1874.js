const fs = require("fs");
// const input = fs.readFileSync('/dev/stdin').toString().trim().split(/\r\n|\r|\n/);
const input = fs
  .readFileSync("input.txt")
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);
let N = parseInt(input.shift());
let arr = input.map((val) => parseInt(val)); //만들어야할 수열
let stack = [];
let ans = [];

let idx = 0; //수열의 인덱스
let num = 1; //숫자

while (true) {
  if (stack.length !== 0 && arr[idx] === stack[stack.length - 1]) {
    stack.pop();
    ans.push("-");
    idx++;
    if (idx === N) break;
    continue;
  } else if (arr[idx] < stack[stack.length - 1]) {
    console.log("NO");
    process.exit();
  }
  if (num <= N) {
    stack.push(num++);
    ans.push("+");
  }
}
console.log(ans.join("\n"));

