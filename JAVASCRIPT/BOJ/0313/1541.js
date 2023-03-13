const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let N = input.shift().split(/[-]/);
let ans = [];
N.forEach(val => {
  let nums = val.split(/[+]/);
  let sum = nums.reduce((pre, cur) => pre + Number(cur),0);
  ans.push(sum);  
})
let result = ans.reduce((pre, cur) => pre - cur);
console.log(result)
