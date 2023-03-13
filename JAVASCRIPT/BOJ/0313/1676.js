const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let N = Number(input[0]);

function fac(num) {
  if (num < 1) return 1n;
  return fac(num - 1) * BigInt(num);
}
let num = String(fac(N));
let cnt = 0;
for (let i = num.length - 1; i >= 0; i--){
  if (Number(num[i])) break;
  else cnt++;
}
console.log(cnt);