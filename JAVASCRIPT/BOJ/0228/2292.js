const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let N = parseInt(input[0]);
let total = 1;
let ans = 1;
const PLUS = 6;
while (true) {
  // console.log(total, ans);
  if (N <= total) break;
  else {
    total += PLUS * ans;
    ans++;
  }
}
console.log(ans);
