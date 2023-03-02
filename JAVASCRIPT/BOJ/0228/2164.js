const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let N = parseInt(input[0]);
let arr = [];
for (let i = 1; i <= N; i++) {
  arr.push(i);
}
let idx = 0;
while (arr.length - 1 !== idx) {
  idx++;
  arr.push(arr[idx++]);
}
console.log(arr[idx]);
