const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(/\r\n|\r|\n/);

let K = parseInt(input.shift());
let stack=[];
input.map(val=>{
  if(parseInt(val)===0)stack.pop();
  else stack.push(parseInt(val));
})
let sum=stack.reduce((pre, cur)=>pre+cur, 0); 
console.log(sum)