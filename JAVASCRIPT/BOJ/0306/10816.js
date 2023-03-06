const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let N = parseInt(input.shift());
let cnt = new Array(20000000).fill(0);
input.shift().split(" ").forEach(val=>cnt[parseInt(val)+10000000]++);
let ans = input[1].split(" ").map(val=>cnt[parseInt(val)+10000000]); 
console.log(ans.join(" "));