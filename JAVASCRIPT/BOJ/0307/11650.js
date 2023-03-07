const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

input.shift();
let arr=[];
input.forEach(line=>{
  arr.push(line.split(" ").map(val=>parseInt(val)));
})
arr.sort((a,b)=>{
  if(a[0]===b[0]) return a[1]-b[1];
  else return a[0]-b[0];
})
let ans = arr.map(val=> val.join(" "));
console.log(ans.join("\n"));
