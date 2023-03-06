const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let K = parseInt(input.shift());
let ans=input.map(val=>val.split(" "));
ans.sort((a,b)=>a[0]-b[0]);
ans = ans.map(v=> v.join(" "));
console.log(ans.join("\n"));

