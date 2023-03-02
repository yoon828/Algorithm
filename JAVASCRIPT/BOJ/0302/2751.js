const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let N = parseInt(input.shift());
let arr = input.map((val)=>parseInt(val));
arr.sort((a,b)=>a-b);
let ans =[];
arr.forEach(val => ans.push(val));
console.log(ans.join("\n"));